package com.ohgiraffers.section01.method;

public class Calculator {
    public int plusTwoNumbers(int first, int second) {
//        int result = first + second;
//        return result;


        return first + second;
    }

    public int minNumbersOf(int first, int second) {
        return (first > second) ? second : first;
    }

    public static int maxNumberOf(int first, int second) {
        return (first > second) ? first : second;
    }
}
