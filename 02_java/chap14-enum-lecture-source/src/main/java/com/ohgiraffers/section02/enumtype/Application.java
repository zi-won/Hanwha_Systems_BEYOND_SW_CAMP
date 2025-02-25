package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {

//        Subjects subject1 = new Subjects(); // 우리가 enum타입의 생성자를 직접 생성 불가
        Subjects subject1 = Subjects.JAVA;   // 호출과 동시에 enum의 모든 열거 타입 상수에 대해 객체 생성
        Subjects subject2 = Subjects.HTML;  // 이미 만들어진 객체 참조
        Subjects subject3 = Subjects.JAVA;

        /* 설명.
         *  1. 열거 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 각각 한 개임을 보장한다.
         *     작성한 순서에 따라 각각은 다른 인스턴스가 생성되며 최초 호출 시에 enum의 생성자를 활용해 생성된다.(lazy singleton 개념)
         * 설명.
         *  2. 단일 인스턴스를 보장하기에 == 비교가 가능하다.(동일 객체 비교)
         * */

//        if (subject1 == subject2) {     // 서로 다르다라고 뜨는 건 다른 객체기 때문
        if (subject1 == subject3) {     // 서로 같은 객체이기 때문(싱글톤 객체이므로)
            System.out.println("두 과목은 같은 과목이다.");
        } else {
            System.out.println("서로 다른 과목이다.");
        }

        /* 설명. 상수 필드명을 문자열로 변경하기 쉽다. */
        System.out.println(Subjects.JAVA.toString());       // 우리가 재정의해서 쓸 수 있다.
        System.out.println(Subjects.JAVA.name());           // enum 상수의 정확한 이름 반환

        /* 설명. 4. values()를 이용하면 상수값 배열을 반환받고 이를 활용하여 연속처리해 줄 수 있다.
         *         (상수 필드들에 주입된 객체들을 순회할 수 있다.)
         * */
        Subjects[] subjects = Subjects.values();
        for (Subjects sub : subjects) {
            System.out.println(sub.toString());
            System.out.println(sub.ordinal());  // enum에 선언된 상수들의 순서를 인덱스 체계로 추출
            System.out.println(sub.name());
        }

        /* 설명. 5. 타입 안정성을 보장한다.
         *  enum은 타입 안정성을 보장하는 특별한 데이터로 잘못된 값이 할당되거나 비교되는 것을 방지한다.
         * */
        printSubjects(Subjects.JAVA);   // Subjects 타입이 아니면 전달할 수 없다.
//        printSubjects(0);             // enum이 아닐 경우 같은 타입의 값을 사용하면 컴파일러가 잘못된 값을 인지 못한다.

    }

    private static void printSubjects(Subjects subjects) {
    }
}
