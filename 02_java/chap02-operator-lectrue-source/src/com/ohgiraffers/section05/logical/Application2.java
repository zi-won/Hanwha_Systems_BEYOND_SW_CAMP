package com.ohgiraffers.section05.logical;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 논리 연산자 활용하기 */
        /* 목차. 1. 1부터 100 사이 값인지 확인 */
        int num1 = 55;
        int num2 = 101;
        System.out.println((num1 >= 1) && (num1 <= 100));
        System.out.println((num2 >= 1) && (num2 <= 100));

        /* 목차. 2. 영어 대문자인지 확인 */
        char ch1 = 'G';
        char ch2 = 'g';
        System.out.println((ch1 >= 'A') && (ch1 <= 'Z'));   // 'A'는 65, 'Z'는 90
        System.out.println((ch2 >= 'A') && (ch2 <= 'Z'));

        /* 목차. 3. 대소문자 상관없이 'y'인지 확인 */
        char ch3 = 'y';
        char ch4 = 'Y';
        System.out.println("y를 입력했는지 확인: " + (ch3 == 'y'|| ch3 == 'Y'));
        System.out.println("y를 입력했는지 확인: " + (ch4 == 'y'|| ch4 == 'Y'));


    }
}
