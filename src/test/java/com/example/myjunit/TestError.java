package com.example.myjunit;

public class TestError {
    private TestCase testCase;
    private Exception exception;

    public TestError(TestCase testCase, Exception exception) {
        this.testCase = testCase;
        this.exception = exception;
    }
// TODO: getTestCaseName 인식안되는 문제 해결할 것!
    public String getTestCaseName() {
        return testCase.getTestCaseName();
    }

    public Exception getException() {
        return exception;
    }
}