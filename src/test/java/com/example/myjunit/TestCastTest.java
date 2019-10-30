package com.example.myjunit;

public class TestCastTest {
    public static void main(String[] args) {
        new TestCastTest().runTest();
    }
    public void runTest () {
        long sum = 10 + 10;
        Assert.assertTrue(sum == 20);
    }
}
