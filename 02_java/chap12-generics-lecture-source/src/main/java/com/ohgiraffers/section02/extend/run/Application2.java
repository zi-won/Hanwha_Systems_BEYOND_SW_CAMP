package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 와일드카드에 대해 이해할 수 있다. */
        /* 설명. 객체 생성과 동시 타입을 정한다는 점이 제네릭과의 차이다. */
        WildCardFarm wildCardFarm = new WildCardFarm();

        Rabbit r = new Rabbit();
        RabbitFarm<Rabbit> rFarm = new RabbitFarm<>(r);
        wildCardFarm.anyType(rFarm);
        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        wildCardFarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));

        wildCardFarm.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
    }
}