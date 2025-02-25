package com.ohgiraffers.section01.generic;

/* 설명.
 *  제네릭 클래스의 다이아몬드 연산자(<>)에 들어갈 수 있는 4가지 타입
 *  1. E: Element
 *  2. T: Type
 *  3. K: Key
 *  4. V: Value
 * */
public class GenericTest<T>{    // T는 타입을 뜻함
    private T value;

    public GenericTest(){
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
