package oop1;

public class MusicPlayer {
    boolean isOn = false;
    int volume;
    void On(){
        isOn = true;
    }
    void Off(){
        isOn = false;
    }
    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }
    void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

    void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨 : " + volume);
        }
        else{
            System.out.println("음악 플레이어 OFF");
        }
    }
}
