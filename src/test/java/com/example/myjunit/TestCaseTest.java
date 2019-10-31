package com.example.myjunit;

import org.junit.jupiter.api.Test;

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
        TestResult testResult = new TestResult();
        // main 메소드에서 TestResult를 생성해서 각각의 테스트케이스에 파라미터로 전달한다.
        // -> 이렇게 되면,
        // 테스트 케이스가 실행될때마다 카운트가 체크되니 전체 카운트를 확인 가능
        new TestCaseTest("runTest").run(testResult);
        new TestCaseTest("runTestMinus").run(testResult);
        // printCount를 통해 미리 선언된 방식으로 레포팅
        testResult.printCount();
    }
}
/*
- 왜 TestCase의 구현체인 TestCaseTest를 new로 인스턴스 생성해서 써야하는가?
: 각각의 테스트가 독립적으로 실행하기 위해
모든 테스트 케이스는 새로운 인스턴스에서 수행되도록 하였음
 */

/*
- printCount를 assertTrue로 검증하지 않는 이유?
: 검증의 영역이 아닌 레포팅 영역이기 때문
차후에 각자 원하는 방식으로 레포팅 형태롤 변경하면 된다. (ex: HTML, JSON 등)
이 부분도 나는 테스트 코드로 작성하고 싶다! 한다면,
getCount와 같은 메소드를 생성하여 검증코드를 추가하셔도 무방하다.
지금은 간단하게 console로 표현하였음
 */