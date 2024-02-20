package oop1;

public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;

    void on() {
        isOn = true;
    }

    void off() {
        isOn = false;
    }
    void volumeUp() {
        volume++;
        System.out.println("현재 볼륨은 " + volume);
    }

    void volumeDown() {
        if (volume > 0) {
            volume--;
            System.out.println("현재 볼륨은 " + volume);
        } else {
            System.out.println("볼륨이 더 이상 줄어들지 않습니다. ");
        }
    }

    void showStatus() {
        if (isOn) {
            System.out.println("현재 음악 플레이어 상태 : ON");
        } else {
            System.out.println("현재 음악 플레이어 상태 : OFF");
        }
    }
}
