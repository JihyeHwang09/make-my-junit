package com.example.myjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase implements Test {
    private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);

    public String testCaseName;

    public TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    // 파라미터 없는 run을 생성
    // TestResult를 자체적으로 인스턴스를 생성한 후,
    // 파라미터가 있는 run 메소드를 호출한다.
    public TestResult run () {
        TestResult testResult = createTestResult();
        run(testResult);

        return testResult;
    }
    // TestResult를 파라미터로 받아서, startTest()를 실행하는 메소드로 수정함
    public void run(TestResult testResult){
        testResult.startTest();
        before();
        // InvocationTargetException과 InvocationTargetException를 분리해서 제어
        // InvocationTargetException는 테스트가 실패했을 때를 나타낸다.
        // - AssertionFailedError로 잡지 않은 이유?
        // : -> method.invoke 때문

        try {
            runTestCase();
        } catch (InvocationTargetException ite) {
            if(isAssertionFailed(ite)){
                testResult.addFailure(this);
            } else {
                testResult.addError(this, ite);
            }
        } catch (Exception e) {
            testResult.addError(this, e);
        } finally {
            after();
        }
    }


    private boolean isAssertionFailed(InvocationTargetException ite) {
        return ite.getTargetException() instanceof AssertionFailedError;
    }

//    private void runTestCase() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        logger.info("{} execute ", testCaseName); // 테스트 케이스들 구별을 위해 name 출력 코드
//        Method method = this.getClass().getMethod(testCaseName, null);
//        // 각각의 테스트 메소드 실행은 method.invoke로 실행된다.
//        // 이 메소드 때문에 Exception이 발생할 경우, InvocationTargetException로 랩핑되어 나간다.
//        // ->  run() 메소드에선 진짜 InvocationTargetException 발생한것인지,
//        // AssertionFailedError가 발생했는데 InvocationTargetException로 랩핑된것인지 알 수가 없다!!!!
//        // -> InvocationTargetException이 발생했을 경우,
//        // 실제 그 안에 있는 Exception이 AssertionFailedError인지 확인하는 메소드 (isAssertionFailed)를 추가한 것이다.
//        // 그 외 다른 Exception에선 모두 Error로 간주하고 처리한다.
//        method.invoke(this, null);
//    }


    private TestResult createTestResult () {
        return new TestResult();
    }

    protected void before () {}

    public void runTestCase() {
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
    protected void after () {}

}
/*
- 각각의 TestCase 이름을 가져야 식별가능하기 때문에
생성자에서 testCaseName을 인자로 받게 만들었다.
- TestCase는 그 자체로 사용하기보다는 이를 상속한 실제 테스트 케이스 클래스들을 사용할 것이기 때문에
추상 클래스(abstract class)로 선언하였다.
 */
