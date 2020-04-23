package com.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    FakeRepoInterface fakeRepo;
    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo){
        this.fakeRepo = fakeRepo;
    }

    @Override
    public String addUser(long Id, String name, String surname) {
        fakeRepo.insertUser(1, "shirley", "ndou");
        fakeRepo.insertUser(2, "John", "Doe");
        fakeRepo.insertUser(3, "Mary", "Jane");
        System.out.println(name + "entered");
        return name;
    }

    @Override
    public void removeUser(long Id) {
        fakeRepo.deleteUser(1);
        System.out.println(getUser(Id) + " removed");
    }

    @Override
    @Cacheable("name")
    public String getUser(long Id) {
       // System.out.println("hello " + fakeRepo.findUserById(Id).getName());
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return fakeRepo.findUserById(Id);
    }
}
