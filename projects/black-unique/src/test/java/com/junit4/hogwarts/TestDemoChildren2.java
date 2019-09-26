package com.junit4.hogwarts;

import org.junit.*;
import org.junit.runners.MethodSorters;
import com.util.time.printTime;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDemoChildren2 extends TestDemoChildren{
    @BeforeClass
    public static void beforeAllTestCase() {
        printTime.printTime();
        System.out.println("I am TestDemoChildren2 before class");
    }

    @AfterClass
    public static void afterAllTestCase() {
        printTime.printTime();
        System.out.println("I am after TestDemoChildren2 class");
    }
    @Before
    public void beforeCase() {
        printTime.printTime();
        System.out.println("I am TestDemoChildren2 before");
    }

    @After
    public void afterCase(){
        System.out.println("I am TestDemoChildren2 after");
        printTime.printTime();
    }

    @Test
    public void testDemo7() {
        System.out.println(7);
        assertTrue(true);
    }

    @Test
    public void testDemo8() {
        System.out.println(8);
        assertFalse(false);
    }

    @Test
    public void testDemo9() {
        System.out.println(9);
        assertFalse(false);
    }
}
