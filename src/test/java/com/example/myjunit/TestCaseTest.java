package com.example.myjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestCaseTest extends TestCase {
    public TestCaseTest (String testCaseName) {
        super(testCaseName);
    }
    private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);
    @Override
    public void run () {
        try {
            // run 메소드에 실행한 테스트 메소드를 확인하기 위해 메소드명을 출력하도록 logger를 추가
            logger.info("{} execute", testCaseName); // 테스트 케이스들 구별을 위해 name 출력 코드
            // 테스트 메소드를 담을 Method 객체 생성
            Method method = this.getClass().getMethod(super.testCaseName, null);
            // 메소드명.invoke(클래스 이름, input parameter)
            // invoke안에 메소드가 들어있는 class와 메소드에 전달된 input parameter를 전달해 준다.
            method.invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void runTest () {
        long sum = 10 + 10;
        Assert.assertTrue(sum == 20);
    }

    public void runTestMinus () {
        long minus = 100 - 10;
        //  테스트 메소드 안에서 처리되어야 할 값들을 assert문 안에 넣어서 예상값과 실제 처리된 값 비교

        Assert.assertTrue(minus == 90);
    }

    public static void main(String[] args) {
        new TestCaseTest("runTest").run();
        new TestCaseTest("runTestMinus").run();
    }
}
/*
- 왜 TestCase의 구현체인 TestCaseTest를 new로 인스턴스 생성해서 써야하는가?
: 각각의 테스트가 독립적으로 실행하기 위해 모든 테스트 케이스는 새로운 인스턴스에서 수행되도록 하였음
 */