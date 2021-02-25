package com.czl.business.service.多线程;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子操作
 *
 * @author czlin
 * @date 2021-02-23 11:47
 */
public class Atomic {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
        LongAdder longAdder = new LongAdder();


    }
}
