package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불 공격🔥");
    }
}
