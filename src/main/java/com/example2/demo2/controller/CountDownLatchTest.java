package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class CountDownLatchTest {
    public static void main(String[] arg) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("T1 finish");
                countDownLatch.countDown();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("T2 finish");
                countDownLatch.countDown();
            }
        }).start();
        log.info("main finish before");
        countDownLatch.await();
        log.info("main finish");
    }


}
