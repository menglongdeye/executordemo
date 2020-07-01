package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


@Slf4j
public class CyclicBarrierTest3 {
    public static void main(String[] arg){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("T1 before");
                    cyclicBarrier.await();
                    log.info("T1 end");
                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {

                }
            }
        });
        thread1.start();
        thread1.interrupt();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            log.info("isBroken=={}",cyclicBarrier.isBroken());
        }

    }

}