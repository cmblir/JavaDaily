package cond.ex;

public class DistanceEx {
    public static void main(String[] args) {
        int distance = 110;
        String ride = null;
        if (distance > 100) {
            ride = "비행기";
        } else if (distance <= 100) {
            ride = "자동차";
        } else if (distance <= 10) {
            ride = "자전거";
        } else if (distance <= 1) {
            ride = "도보";
        }
        System.out.println("distance : " + distance);
        System.out.println("출력 : " + ride + "를 이용하세요.");
    }
}
