package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Scanner를 이용해 다양한 자료형의 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 설명. 0. next()를 활용한 문자열 입력(next()는 띄어쓰기나 엔터가 인지되지 않는다.(버퍼에 남아있다.)
         *  따라서 다음에 next를 만나면 버퍼에 남아있는 엔터나 띄어쓰기가 작동되어 입력을 할 수 없게 된다.
         *  */
        System.out.print("소속을 입력하세요: ");
        String className = sc.next();
        System.out.println("className: " + className);

        sc.nextLine();      // 유일하게 엔터를 인식하기 때문에 버퍼에 있는 엔터 제거용

        /* 설명. 1. nextLine()을 활용한 콘솔(console)에서의 문자열 입력 */
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("name = " + name);

        /* 설명. 2. nextInt()를 활용한 정수 입력*/
        System.out.print("내 나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("age = " + age);

        /* 설명. 3. nextDouble()을 활용한 실수 입력 */
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("height = " + height);

    }
}
