package com.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

public class UserServiceImpl implements UserService {
    FakeRepoInterface fakeRepo;
    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo){
        this.fakeRepo = fakeRepo;
    }
    @Cacheable("name")
    @Override
    public String addUser(long Id, String name, String surname) {
        fakeRepo.insertUser(1, "shirley", "ndou");
        System.out.println(name + "entered");
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return name;
    }

    @Override
    public void removeUser(long Id) {
        fakeRepo.deleteUser(1);
        System.out.println(getUser(Id) + " removed");
    }

    @Cacheable("name")
    @Override
    public long getUser(long Id) {
        System.out.println("hello " + fakeRepo.findUserById(1).getName());
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return Id;
    }
}
