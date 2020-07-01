package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


@Slf4j
public class JoinCountDownLatchTest {
    public static void main(String[] arg) throws Exception{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("T1 finish");
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("T2 finish");
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("main finish");
    }


}
