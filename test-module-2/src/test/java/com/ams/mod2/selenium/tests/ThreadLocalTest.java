package com.ams.mod2.selenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    static ThreadLocal tl;

    @BeforeEach
    void doBeforeEach(){
        if (tl == null){
            tl = new ThreadLocal();
            tl.set(Thread.currentThread().getName());
        }else{
            System.out.println("ThreadLocal is already set and = " + tl.get());
        }
    }

    @Test
    void doMock1(){
        System.out.println("doMock1, class = " + this.getClass().getName());
    }

    @Test
    void doMock2(){
        System.out.println("doMock2, class = " + this.getClass().getName());
    }
}
