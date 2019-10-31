package com.example.myjunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest (String testCaseName) {
        super(testCaseName);
    }

    private static long base;

    public void before () {
        base = 10;
    }

    public void runTest () {
        long sum = 10 + base;
        Assert.assertTrue(sum == 20);
    }

    public void runTestMinus () {
        long minus = 100 - base;
        //  테스트 메소드 안에서 처리되어야 할 값들을 assert문 안에 넣어서
        //  예상값과 실제 처리된 값 비교
        Assert.assertTrue(minus == 90);
    }

    public static void main(String[] args) {
        new TestCaseTest("runTest").run();
        new TestCaseTest("runTestMinus").run();
    }
}
/*
- 왜 TestCase의 구현체인 TestCaseTest를 new로 인스턴스 생성해서 써야하는가?
: 각각의 테스트가 독립적으로 실행하기 위해
모든 테스트 케이스는 새로운 인스턴스에서 수행되도록 하였음
 */