package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


@Slf4j
public class CyclicBarrierTest2 {
    public static void main(String[] arg) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new DemoClass());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("T1 before");
                    cyclicBarrier.await();
                    log.info("T1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        cyclicBarrier.await();log.info("main");
    }


    static class DemoClass implements Runnable{
        @Override
        public void run() {
            log.info("T2");
        }
    }


}
