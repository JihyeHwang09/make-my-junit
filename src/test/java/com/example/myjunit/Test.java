package com.example.myjunit;

// Composite 패턴의 Component에서 가질 메소드도 오직 run()만 있으면 된다.
public interface Test {
    void run(TestResult result);
}
