package com.example.myjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class TestCase {
    private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);

    protected String testCaseName;

    public TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public void run() {
        try {
            // run 메소드에 실행한 테스트 메소드를 확인하기 위해 메소드명을 출력하도록 logger를 추가
            logger.info("{} execute", testCaseName); // 테스트 케이스들 구별을 위해 name 출력 코드
            // 테스트 메소드를 담을 Method 객체 생성
            Method method = this.getClass().getMethod(testCaseName, null);
            // 메소드명.invoke(클래스 이름, input parameter)
            // invoke안에 메소드가 들어있는 class와 메소드에 전달된 input parameter를 전달해 준다.
            method.invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
/*
- 각각의 TestCase 이름을 가져야 식별가능하기 때문에
생성자에서 testCaseName을 인자로 받게 만들었다.
- TestCase는 그 자체로 사용하기보다는 이를 상속한 실제 테스트 케이스 클래스들을 사용할 것이기 때문에
추상 클래스(abstract class)로 선언하였다.
 */
