package com.junit4.hogwarts;

import org.junit.*;
import org.junit.runners.MethodSorters;
import com.util.time.printTime;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDemoChildren extends TestDemo{
    @BeforeClass
    public static void beforeAllTestCase() {
        printTime.printTime();
        System.out.println("I am TestDemoChildren before class");
    }

    @AfterClass
    public static void afterAllTestCase() {
        printTime.printTime();
        System.out.println("I am after TestDemoChildren class");
    }

    @Before
    public void beforeCase() {
        printTime.printTime();
        System.out.println("I am TestDemoChildren before");
    }

    @After
    public void afterCase(){
        printTime.printTime();
        System.out.println("I am TestDemoChildren after");
    }

    @Test
    public void testDemo4() {
        System.out.println(4);
        assertTrue(true);
    }

    @Test
    public void testDemo5() {
        System.out.println(5);
        assertFalse(false);
    }

    @Test
    public void testDemo6() {
        System.out.println(6);
        assertFalse(false);
    }
}
