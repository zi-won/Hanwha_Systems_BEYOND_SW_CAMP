package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.Bunny;
import com.ohgiraffers.section02.extend.vo.DrunkenBunny;
import com.ohgiraffers.section02.extend.vo.Rabbit;
import com.ohgiraffers.section02.extend.vo.RabbitFarm;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 제네릭 클래스를 좀 더 활용하는 예제를 이해할 수 있다. */
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();    //컴파일 에러 발생
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<>();    // 컴파일 에러 발생
//        RabbitFarm<Snake> farm3 = new RabbitFarm<>();     // 컴파일 에러 발생

        /* 설명. <T extends Rabbit>에 의해 Rabbit 및 하위 타입으로만 제네릭 객체 생성 가능 */
        /* 설명. 객체 생성과 동시에 타입 결정하는 점이 제네릭과의 차이점 */
        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();

        farm4.setRabbit(new Rabbit());
        farm4.getRabbit().cry();
        farm4.setRabbit(new Bunny());
        farm4.getRabbit().cry();            // 동적 바인딩

//        farm5.setRabbit(new Rabbit());     // 컴파일 에러 발생
        farm5.setRabbit(new Bunny());       // 같은 타입 포함 하위 타입으로 가능
        farm5.getRabbit().cry();
    }
}
