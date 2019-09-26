package com.junit4.hogwarts;

import org.junit.*;
import org.junit.runners.MethodSorters;
import com.util.time.printTime;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDemo {
    @BeforeClass
    public static void beforeAllTestCase() {
        printTime.printTime();
        System.out.println("I am before class");
    }

    @AfterClass
    public static void afterAllTestCase() {
        printTime.printTime();
        System.out.println("I am after class");
    }

    @Before
    public void beforeCase() {
        printTime.printTime();
        System.out.println("I am before");
    }

    @After
    public void afterCase(){
        printTime.printTime();
        System.out.println("I am after");
    }

    @Test
    public void testDemo() {
        System.out.println(1);
        assertTrue(true);
    }

    @Test
    public void testDemo3() {
        System.out.println(3);
        assertFalse(false);
    }

    @Test
    public void testDemo2() {
        System.out.println(2);
        assertFalse(false);
    }
}
