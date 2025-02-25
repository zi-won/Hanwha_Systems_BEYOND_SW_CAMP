package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperClass {

    /* 설명. 부모 메소드의 헤드부와 일치하게 오버라이딩 */
//    @Override
//    public void method(int num) {
//
//    }

    /* 설명. 메소드 이름 변경(feat. 새로운 메소드를 생성한 셈) */
//    @Override
//    public void method1(int num) {      // method1이 없기 때문에 에러 발생
//
//    }

    /* 설명. 메소드의 반환형(리턴 타입) 변경 */
//    @Override
//    public String method(int num) {
//        return null;
//    }

    /* 설명. 경우에 따라서는 메소드의 반환형을 달리 해도 오버라이딩이 성립한다.
      * (부모 메소드 리턴 타입의 자식 타입으로는 가능)
      * Object는 모든 클래스의 부모이기 때문에 아무 타입이나 가능하다.
      * */
    @Override
    public String method2(int num) {
        return null;
    }

    /* 설명. 부모 메소드가 private이라면 오버라이딩 불가 */
//    @Override
//    private void privateMethod(){
//
//    }

    /* 설명. final 메소드는 오버라이딩 불가*/
//    @Override
//    public final void finalMethod() {}

    /* 설명. 다른 패키지더라도 상속관계이므로 오버라이딩 성립 */
    @Override
//    protected void protectedMethod() {
//    }
    public void protectedMethod() {}        // 더 큰 범위로 접근 제어자를 바꾸는 건 성립
    /* 설명. default는 다른 패키지일 경우 상속 불가이므로 부모클래스가 다른 패키지가 되면 오버라이딩 불가 */
//    @Override
//    void defaultMethod() {
//
//    }
}
