package at.htl.finoview.controller;

import org.junit.jupiter.api.*;

public class TestLifecyleDemoTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all ...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each ...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each ...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all ...");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }

    @Test
    void test3() {
        System.out.println("Test 3");
    }

    @Test
    void test4() {
        System.out.println("Test 4");
    }

}
