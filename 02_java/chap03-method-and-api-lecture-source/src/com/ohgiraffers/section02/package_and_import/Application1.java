package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 설명.
          * 패키지의 의미
          * 1. 클래스의 소속
          * 2. 원래는 클래스명의 일부분이다.
          * 3. 경우에 따라 생략 가능하다.(같은 패키지일 경우)
          * */

        /* 설명. non-static 메소드 호출을 위해 Calculator 인지(feat. 다른 패키지에서) */
//        com.ohgiraffers.section01.method.Calculator cal = new com.ohgiraffers.section01.method.Calculator();

//        int plusResult = cal.plusTwoNumbers(100, 20);
//        System.out.println("100과 20의 합: " + plusResult);
        /* 설명. 다른 패키지에 있기 때문에 static 변수더라도 생략하면 안된다. -> 이것을 해결하기 위해 import가 있다. */
        int maxResult = com.ohgiraffers.section01.method.Calculator.maxNumberOf(100, 20);
        System.out.println("두 수 중 큰 값은? " + maxResult);
    }
}
