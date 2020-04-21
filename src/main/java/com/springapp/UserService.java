package com.springapp;

public interface UserService {

    String addUser(long Id, String name, String surname);
    void removeUser(long Id);
    long getUser(long Id);
}
