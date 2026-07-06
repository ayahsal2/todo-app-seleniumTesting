package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.models.User;

public class UserUtils {
    public User generateRandomUser(){
        String fname = new Faker().name().firstName();
        String lname= new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        User user = new User(fname,lname,email,password);
        return user;
    }
}
