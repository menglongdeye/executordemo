package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;


@Slf4j
public class BnakWterTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4,new BankWaterService());
    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    private static Executor executor = Executors.newFixedThreadPool(4);

    public static void main(String[] arg) throws Exception{
        for (int i=0;i<4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    int k = (int)(Math.random()*100);
                    log.info("线程{}随机值{}",Thread.currentThread().getName(),k);
                    map.put(Thread.currentThread().getName(),k);
                    try {
                        cyclicBarrier.await();
                        log.info("线程{}执行完毕",Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    static class BankWaterService implements Runnable{
        @Override
        public void run() {
            int result = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                result += entry.getValue();
            }
            log.info("最终结果：{}",result);
        }
    }

}
