package com.example.myjunit;

import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assert {
    // slf4j logger가 의존성으로 등록되어있기 때문에 logger는 sfl4j logger를 사용한다.
    private static final Logger logger = LoggerFactory.getLogger(Assert.class);

    private Assert () {} // 인스턴스 생성을 막기 위해 기본생성자를 private으로 선언

    // parameter로 넘겨진 boolean 값이 true이면 Test는 성공 -> logger.info("Test Passed!!"가 실행됨
    public static void assertTrue (boolean condition) {
    // false이면  throw new AssertionFailedError();로 테스트 실패를 알린다.
        if (!condition) {
            throw new AssertionFailedError();
        }
        logger.info("Test Passed");
    }
}
