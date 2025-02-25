package com.ohgiraffers.section02.abstractclass;

public class Phone extends Product {
    public Phone() {
        super();
    }

    /* 설명. 부모 클래스에 불완전한 메소드가 있기 때문에 불완전한 메소드를 오버라이딩하여 재정의함으로 써 오류 제거
      * (부모클래스가 불완전하므로 클래스에 abstract를 해줌으로 써 오류 제거 가능) public abstract Phone extends Product
      * */
    @Override
    public void abstractMethod() {
        System.out.println("안 뺴먹고 오버라이딩 했다잉~");
    }
}
