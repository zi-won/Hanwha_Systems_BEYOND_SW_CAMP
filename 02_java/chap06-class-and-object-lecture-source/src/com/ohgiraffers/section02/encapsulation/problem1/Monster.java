package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        if(hp >= 0) {
            this.hp = hp;   // this는 setHP를 호출한 객체를 뜻함.
        } else {
            this.hp = 0;
        }
    }
}
