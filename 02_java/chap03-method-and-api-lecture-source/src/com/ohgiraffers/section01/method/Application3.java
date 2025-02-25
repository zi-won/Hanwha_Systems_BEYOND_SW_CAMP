package com.ohgiraffers.section01.method;

public class Application3 {

    static int global = 10;     // 전역변수이자 static변수

    public static void main(String[] args) {

        /* 수업목표. 메소드 전달인자(argument)와 매개변수(parameter)에 대해 이해하고 메소드 호출 시 활용할 수 있다. */
        /* 설명.
         *  변수를 선언한 위치에 따라 구분할 수도 있다.
         *  1. 지역변수: 해당 지역 안에서만 쓸 수 있는 변수
         *  2. 전역변수: 클래스 전체에서 쓸 수 있는 변수
         *  3. 매개변수: 전달 받은 값을 저장하는 변수
        * */

        System.out.println("전역변수: " + global);

        Application3 app3 = new Application3();
        app3.testMethod(13);        // 이때 13은 전달인자(argument)
        app3.testMethod(11);
        app3.testMethod('a');       // 자동 형변화으로 인해 int로 자동변환

        int local = 20;                 // 지역 변수(선언 이후부터 인지가 되므로 선언 전에 변수를 쓰면 오류 발생) -> 다음 행부터 이용 가능
        System.out.println("지역 변수: " + local);
    }


    public void testMethod(int age) {   // age는 매개변수(parameter)
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}
