package com.example.myjunit;

public abstract class TestCase {
    protected String testCaseName;

    public TestCase (String testCaseName) {
        this.testCaseName = testCaseName;
    }
    public abstract void run();
}
/*
- 각각의 TestCase 이름을 가져야 식별가능하기 때문에
생성자에서 testCaseName을 인자로 받게 만들었다.
- TestCase는 그 자체로 사용하기보다는 이를 상속한 실제 테스트 케이스 클래스들을 사용할 것이기 때문에
추상 클래스(abstract class)로 선언하였다.
 */
