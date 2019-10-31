package com.example.myjunit;

// TestFailure: 실패한 케이스만 저장
// TestError:  어떤 Exception이 발생했는지를 저장
public class TestFailure {
    private TestCase testCase;

    public TestFailure (TestCase testCase) {
        this.testCase = testCase;
    }
    public String getTestCaseName() {
        return testCase.getTestCaseName();
    }
}

