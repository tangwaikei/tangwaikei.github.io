package com.junit4.hogwarts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestDemo.class,
        TestDemoChildren.class,
        TestDemoChildren2.class
})
public class TestSuites {

}
