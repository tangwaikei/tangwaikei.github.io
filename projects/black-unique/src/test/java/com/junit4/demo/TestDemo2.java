package com.junit4.demo;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDemo2 extends TestDemo {
    //验证超时
    @Test(timeout=100)
    public void testAdd2() throws InterruptedException {
        Thread.sleep(101);
        new Count().add(1, 1);
    }

    //验证抛出异常
    @Test(expected=ArithmeticException.class)
    public void testDivision() {
        new Count().division(8, 0);
    }

    // 跳过该条用例
    @Ignore
    @Test
    public void testAdd3() {
        Count count = new Count();
        System.out.println("testAdd3");
        int result = count.add(2,2);
        assertEquals(result, 5);
    }
}
