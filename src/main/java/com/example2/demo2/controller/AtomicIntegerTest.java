package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger(3);
    public static void main(String[] arg){
        int old = atomicInteger.get();
        int a = atomicInteger.getAndIncrement();
        int newValue = atomicInteger.get();

        log.info("{}===={}===={}",old,a,newValue);
    }
}
