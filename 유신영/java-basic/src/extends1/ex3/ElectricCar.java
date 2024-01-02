package extends1.ex3;

import java.util.Scanner;

public class ElectricCar extends Car {
    @Override
    // static, final, private는 오버라이딩 불가
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다.");
    }

    public void charge() {
        System.out.println("차량을 충전합니다.");
    }
}

