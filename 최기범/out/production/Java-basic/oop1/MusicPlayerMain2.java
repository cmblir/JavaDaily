package oop1;

public class MusicPlayerMain2 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();
        //���� �÷��̾� �ѱ�
        On(data);
        //���� ����
        volumeUp(data);
        //���� ����
        volumeUp(data);
        //���� ����
        volumeDown(data);
        //���� �÷��̾� ����
        showStatus(data);
        //���� �÷��̾� ����
        Off(data);
    }
    static void On(MusicPlayerData data){
        data.isOn = true;
    }
    static void Off(MusicPlayerData data){
        data.isOn = false;
    }

    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("���� �÷��̾� ����:" + data.volume);
    }
    static void volumeDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("���� �÷��̾� ����:" + data.volume);
    }

    static void showStatus(MusicPlayerData data) {
        System.out.println("���� �÷��̾� ���� Ȯ��");
        if (data.isOn) {
            System.out.println("���� �÷��̾� ON, ���� : " + data.volume);
        }
        else{
            System.out.println("���� �÷��̾� OFF");
        }
    }
}