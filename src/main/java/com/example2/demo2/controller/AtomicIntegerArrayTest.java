package com.example2.demo2.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerArray;

@Slf4j
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{5,8};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);
    public static void main(String[] arg){
        int a = atomicIntegerArray.getAndSet(1,19);
        int b = atomicIntegerArray.get(1);
        int c = value[1];
        log.info("{}===={}===={}",a,b,c);
    }
}
