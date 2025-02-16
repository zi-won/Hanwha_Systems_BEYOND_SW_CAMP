package com.ohgiraffers.section06.statickeyword;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. static 키워드에 대해 이해할 수 있다. */
        /* 설명.
          * static: 프로그램이 실행될 때 정적 메모리 영역(static 영역 또는 클래스 영역)에 할당하는 키워드이다.
          * 여러 인스턴스가 공유해서 사용할 목적의 공간이다.
          * 대표적인 예로 싱글톤(singleton) 객체 또는 설정값(DB 연결 정보)을 담을 용도가 있다.
          * */

        /* 설명.
          * 자바에서 정적 변수와 인스턴스 변수는 자동으로 기본값으로 초기화되는데 int는 기본값이 0으로 초기화 된다.
          * 그래서 NonStaticCount와 StaticCount는 StaticTest 객체가 생성될 때 기본적으로 0으로 시작한다.
          * */
        StaticTest st1 = new StaticTest();

        /* 설명. 현재 두 필드가 가지고 있는 값 확인 */
        System.out.println("non-static field: " + st1.getNonStaticCount());
        System.out.println("static field: " + StaticTest.getStaticCount());

        /* 설명. 각 필드 값들을 증가 */
        /* 설명.
          * 1. NonStaticCount는 인스턴스 변수이기 때문에 이 변수는 특정 객체에 속한 값이다.
          *    (인스턴스 변수는 객체마다 별도로 관리되기 떄문에 객체 이름을 통해 접근해야 한다.)
          *    그래서 st1.getNonStaticCount()와 같이 객체를 통해 호출해야 한다.
          * 2. StaticCount는 정적 변수(static 변수)이기 떄문에 이 변수는 클래스 차원에서 공유된다.
          *    (정적 변수는 모든 객체에서 동일하게 공유되므로 클래스 이름을 통해 접근해야 한다.)
          *    물론 객체 이름을 통해 접근도 가능하나 객체에 속한 것처럼 보일 수 있으므로 가독성을 위해 클래스 이름으로 접근해야 한다.
          *    그래서 StaticTest.increaseStaticCount()와 같이 클래스 이름을 통해 호출해야 한다.
          * */
        st1.increasesNonStaticCount();
        StaticTest.increaseStaticCount();

        /* 설명. 두 필드 값 확인 */
        System.out.println("non-static field: " + st1.getNonStaticCount());
        System.out.println("static field: " + StaticTest.getStaticCount());

        /* 설명. 새로운 객체 생성 후 적용 */
        StaticTest st2 = new StaticTest();
        System.out.println("non-static field: " + st2.getNonStaticCount());
        System.out.println("static field: " + StaticTest.getStaticCount());

    }
}
