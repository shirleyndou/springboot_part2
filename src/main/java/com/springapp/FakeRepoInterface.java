package com.springapp;

public interface FakeRepoInterface {
    int insertUser(long Id, String name, String surname);
    String findUserById(long Id);
    int deleteUser(long Id);
}
