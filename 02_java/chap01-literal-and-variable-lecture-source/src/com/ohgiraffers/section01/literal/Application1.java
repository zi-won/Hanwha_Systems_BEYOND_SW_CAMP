package com.ohgiraffers.section01.literal;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Application1 {
    public static void main(String[] args) {

        // 한줄 주석

        /*
        * 여기도 주석
        * 아래도 주석
        * */

        /* 수업목표. 여러 가지 값의 형태를 출력할 수 있다. */
        /* 목차. 1. 숫자 형태의 값 */
        /* 목차. 1-1. 정수 형태의 값 출력 */
        System.out.println(123);

        /* 목차. 1-2. 실수 형태의 값 출력 */
        System.out.println(1.234);

        /* 목차. 2. 문자 형태의 값 출력 */
        System.out.println('a');
        System.out.println('1');
        System.out.println('\u0000');   // '(싱글 쿼테이션)은 값이 없으면 안되므로 \u0000(유니코드 상 값이 없는 문자)을 넣는다.

        /* 목차. 3. 문자열 형태의 값 출력 */
        System.out.println("안녕하세요");
        System.out.println("a");
        System.out.println("");

        /* 목차. 논리 형태의 값 출력 */
        System.out.println(true);
//        System.out.println("true");   // 이건 문자열이지 논리형이 아니다.
        System.out.println(false);
    }
}
