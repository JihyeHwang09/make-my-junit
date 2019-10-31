package com.example.myjunit;

import java.util.ArrayList;
import java.util.List;

// 각각의 TestCase를 관리할 클래스를 생성
public class TestSuite implements Test {
    private List<TestCase> testCases = new ArrayList<>();

    @Override
    public void run (TestResult result) {
        // Leaf 역할을 TestCase에게 위임한다.
        // 효과: 외부의 클라이언트는 Test 인터페이스 스펙만으로
        // TestCase, TestSuite를 모두 다룰 수 있게 된다.
        for (TestCase testCase : this.testCases) {
            testCase.run(result);
        }
    }

    // TestSuite에서 TestCase를 추가할 수 있도록 addTestCase를 public으로 생성함
    public void addTestCase (TestCase testCase) {
        this.testCases.add(testCase);
    }
}
