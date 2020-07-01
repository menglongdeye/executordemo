package com.example2.demo2.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class ExchangerTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(2);
    private static Exchanger<User> exchanger = new Exchanger<>();
    public static void main(String[] arg) throws Exception{
        executor.execute(new Runnable() {
            @Override
            public void run() {
                User user1 = new User("lcl",18);
                try {
                    exchanger.exchange(user1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("T1 end");
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                User user2 = new User("mm",15);
                try {
                    User user1 = exchanger.exchange(user2);
                    log.info("user1【{}】",user1.getAge());
                    log.info("user2【{}】",user2.getAge());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.info("T2 end");
            }
        });
        executor.shutdown();
    }

    public static class User{
        public volatile String name;
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
