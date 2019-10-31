package com.example.myjunit;

import java.lang.reflect.Method;

public class TestCaseTest extends TestCase {
    public TestCaseTest (String testCaseName) {
        super(testCaseName);
    }

    @Override
    public void run () {
        try {
            Method method = this.getClass().getMethod(super.testCaseName, null);
            method.invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void runTest () {
        long sum = 10 + 10;
        Assert.assertTrue(sum == 20);
    }
    public static void main(String[] args) {
        new TestCaseTest("runTest").run();
    }
}
/*
- 왜 TestCase의 구현체인 TestCaseTest를 new로 인스턴스 생성해서 써야하는가?
: 각각의 테스트가 독립적으로 실행하기 위해 모든 테스트 케이스는 새로운 인스턴스에서 수행되도록 하였음
 */