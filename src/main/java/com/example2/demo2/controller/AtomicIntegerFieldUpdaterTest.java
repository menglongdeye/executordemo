package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


@Slf4j
public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<User> userAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");
    public static void main(String[] arg){
        User user = new User("lcl",18);
        int a = userAtomicIntegerFieldUpdater.getAndIncrement(user);
        int b = userAtomicIntegerFieldUpdater.get(user);
        log.info("{}===={}",a,b);
    }

    public static class User{
        private String name;
        public volatile int age;

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
