package com.ohgiraffers.section01.method;

public class Application7 {
    public static void main(String[] args) {

        /* 수업목표. 다른 클래스에 작성한 메소드를 활용할 수 있다. */
        Calculator calc = new Calculator();     // Calculator 클래스에 작성될 non-static 메소드를 인지

        int first = 100;
        int second = 50;

        /* 설명. 덧셈 */
        System.out.println("두 수의 합은? " + calc.plusTwoNumbers(first, second));

        /* 설명. 최솟값 */
        System.out.println("두 수 중 작은 값은? " + calc.minNumbersOf(first, second));

        /* 설명. 최댓값 */
        System.out.println("두 수 중 큰 값은? " + calc.maxNumberOf(first, second));
    }
}
