package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class SemaphoreTest {
    private static final int THREAD_COUNT = 10;
    private static Executor executor = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore = new Semaphore(2);
    public static void main(String[] arg) throws Exception{
       for(int i=0;i<THREAD_COUNT;i++){
           executor.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       semaphore.acquire();
                       log.info("当前线程{}",Thread.currentThread().getName());
                       semaphore.release();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
           });
       }
    }


}
