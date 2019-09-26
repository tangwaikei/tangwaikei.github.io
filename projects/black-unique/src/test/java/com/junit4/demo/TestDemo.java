package com.junit4.demo;

import com.util.time.printTime;
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDemo {

    @BeforeClass
    public static void addAll() {
        printTime.printTime();
        System.out.println("I am add before class");
    }

    @AfterClass
    public static void deleteAll() {
        printTime.printTime();
        System.out.println("I am delete after class");
    }

    @Before
    public void add(){
        printTime.printTime();
        System.out.println("I am add before each");
    }

    @After
    public void delete() {
        printTime.printTime();
        System.out.println("I am delete after each");
    }

    @Test
    public void testAdd() {
        int a = 2 + 2;
        assertEquals(a, 4);
        System.out.println("I am test fun1");
    }

    @Test
    public void testDec() {
        int b = 5 - 3;
        assertEquals(2, b);
        System.out.println("I am test fun2");
    }
}
