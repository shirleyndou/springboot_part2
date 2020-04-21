package com.springapp;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeRepo implements FakeRepoInterface {
   private static List<User> user = new ArrayList<>();
   //insert the user with the id, name and surname
    @Override
    public int insertUser(long Id, String name, String surname) {
        user.add(new User(Id, name, surname));
        System.out.println("name: " + name);
        return 1;
    }

    //find the user by Id
    @Override
    public User findUserById(long Id) {
        for(User value : user){
            if(value.getId() == Id){
                System.out.println("User found: " + value.getName());
                return value;
            }
        }
        return null;
    }

    //remove the user by Id from the object array
    @Override
    public int deleteUser(long Id) {
        for(User value : user){
            if(value.getId() == Id){
                user.remove(Id);
                return 0;
            }
        }
        return 1;
    }

}
