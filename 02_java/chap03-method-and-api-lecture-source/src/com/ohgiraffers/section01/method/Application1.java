package com.ohgiraffers.section01.method;
/* 설명.
 *  static은 간단히 말해서 자바가 볼 수 있게 해주는 것이다. static을 쓰지 않으면 볼 수 없음.
 *  static을 사용하면 시작할 때 자바가 인지하고 시작함.
 *  void는 간단히 말해서 출구라고 생각하면 된다.(출력값 없는 출구)
 *  method는 stack구조이다.(FILO)
* */
public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 메소드의 호출 흐름에 대해 이해할 수 있다. */
        System.out.println("main() 시작함...");
        methodA();
        System.out.println("main() 종료함...");

    }
    // main에서 호출하지 않으면 method는 쓰이지 않음
    public static void methodA() {
        System.out.println("methodA() 호출됨...");
        methodB();
        System.out.println("methodA() 종료됨...");

    }

    public static void methodB() {
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }

}
