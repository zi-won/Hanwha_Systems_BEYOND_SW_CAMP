package com.ohgiraffers.section03.abstraction;

public class Car {

    private boolean isOn = false;
    private int speed;

    public void startUp() {
        if(this.isOn) {
            System.out.println("이미 시동이 걸려 있습니다.");
        } else {
            this.isOn = true;
            System.out.println("시동을 걸었습니다. 부릉부릉!~");
        }

    }

    public void go() {
        if(this.isOn) {
            this.speed += 10;
            System.out.println("차가 앞으로 움직입니다. 현재 속도는" + speed);
        } else {
            System.out.println("차의 시동이 걸려있지 않습니다. 시동을 먼저 걸어주세요.");
        }
    }

    public void stop() {
        if(isOn) {
            if(speed > 0) {
                speed = 0;
                System.out.println("급 브레이크를 밟았습니다. 차가 멈춥니다.");
            } else{
                System.out.println("차가 이미 멈춰 있는 상태입니다.");
            }
        } else {
            System.out.println("차의 시동이 걸려있지 않습니다. 시동을 먼저 걸어주세요.");
        }
    }

    public void turnOff() {
        if(isOn) {
            if (speed > 0) {
                System.out.println("달리는 상태에서 시동을 끌 수 없습니다. 차를 우선 멈춰주세요.");
            } else {
                isOn = false;
                System.out.println("시동을 끕니다. 다시 운행하시려면 시동을 켜 주세요!~");
            }
        } else {
            System.out.println("이미 시동이 꺼져 있는 상태입니다. 시동 상태를 확인해주세요.");
        }
    }
}
