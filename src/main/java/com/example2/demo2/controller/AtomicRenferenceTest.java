package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;


@Slf4j
public class AtomicRenferenceTest {
    static AtomicReference<User> userAtomicReference = new AtomicReference<User>();
    public static void main(String[] arg){
        User user = new User("lcl",18);
        userAtomicReference.set(user);
        User updateUser = new User("mm",16);
        userAtomicReference.compareAndSet(user,updateUser);
        log.info("{}===={}",userAtomicReference.get().name,userAtomicReference.get().age);
    }

    static class User{
        private String name;
        private int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return this.getName();
        }

        public int getAge(){
            return this.age;
        }
    }
}
