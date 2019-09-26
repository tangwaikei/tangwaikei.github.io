package com.junit5.demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class JUnit5NewTests {

    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void start(){
        System.out.println("I am start");
    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void end(){
        System.out.println("I am end");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("I am beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("I am afterAll");
    }

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @DisplayName("描述测试用例╯°□°）╯")
    void testWithDisplayName(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @Disabled("这条用例暂时跑不过，忽略!")
    void myFailTest(){
        assertEquals(1,2);
    }

    @Test
    @DisplayName("运行一组断言")
    void assertAllCase() {
        Assertions.assertAll("groupAssert",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(true)
        );
    }

    @Test
    @DisplayName("依赖注入1")
    void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("依赖注入2")
    void testReporter(final TestReporter testReporter) {
        testReporter.publishEntry("name", "Alex");
    }

}
