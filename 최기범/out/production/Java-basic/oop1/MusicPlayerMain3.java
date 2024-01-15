package oop1;

public class MusicPlayerMain3 {
    public static void main(String[] args) {
        MusicPlayer data = new MusicPlayer();
        //음악 플레이어 켜기
        data.On();
        //볼륨 증가
        data.volumeUp();
        //볼륨 증가
        data.volumeUp();
        //볼륨 감소
        data.volumeDown();
        //음악 플레이어 상태
        data.showStatus();
        //음악 플레이어 끄기
        data.Off();
    }
}