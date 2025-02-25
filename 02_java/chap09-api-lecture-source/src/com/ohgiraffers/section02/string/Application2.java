package com.ohgiraffers.section02.string;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 문자열 객체를 생성하는 다양한 방법을 숙지하고 인스턴스가 생성되는 방식을 이해할 수 있다. */
        /* 설명.
          * 문자열 객체를 만드는 방법
          * 1. "" 리터럴 형태: 동일한 값을 가지는 인스턴스(동등(equals, hashCode))를 단일 인스턴스로 관리한다.
          *                    (일종의 singleton 개념, 상수풀(constant pool) 활용)
          * 2. new String("") 형태: 매번 새로운 인스턴스를 생성한다.(주소값이 매번 다름)
          * */
        String str1 = "java";       // java는 heap 영역 안에 상수풀에 저장
        String str2 = "java";       // 새로 생성되지 않고 상수풀에 있는 java 값을 참조함
        String str3 = new String("java");       // heap 영역에 저장
        String str4 = new String("java");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str2 == str3: " + (str2 == str3));      // 상수풀 영역과 heap 영역과의 비교라 false
        System.out.println("str3 == str4: " + (str3 == str4));      // 주소값이 다르기 때문에 false

        System.out.println("문자열 비교는 equals()를 사용하자: " + str2.equals(str3));
        System.out.println("haseCode()도 확인: " + str2.hashCode() + ", " + str3.hashCode());

        /* 설명. 문자열은 불변객체(immutable object)로 변화를 주면 항상 새로운 객체(인스턴스)가 생성된다. */
        String str = "apple";
        System.out.println(System.identityHashCode(str));
        str += ", banana";
        System.out.println(System.identityHashCode(str));
    }
}
