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
        System.out.println("���� �÷��̾� ����:" + volume);
    }
    void volumeDown() {
        volume--;
        System.out.println("���� �÷��̾� ����:" + volume);
    }

    void showStatus() {
        System.out.println("���� �÷��̾� ���� Ȯ��");
        if (isOn) {
            System.out.println("���� �÷��̾� ON, ���� : " + volume);
        }
        else{
            System.out.println("���� �÷��̾� OFF");
        }
    }
}
