package com.junit4.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestDemo.class,
        TestDemo2.class
})
public class TestSuite {
}
