package oop1;

public class MusicPlayerMain1 {
    public static void main(String[] args) {
        int volume = 0;
        boolean isOn = false;
        //���� �÷��̾� �ѱ�
        isOn = true;
        System.out.println("���� �÷��̾ �����մϴ�");
        //���� ����
        volume++;
        System.out.println("���� �÷��̾� ����:" + volume);
        //���� ���� volume++;
        System.out.println("���� �÷��̾� ����:" + volume);
        //���� ����
        volume--;
        System.out.println("���� �÷��̾� ����:" + volume);
        //���� �÷��̾� ����
        System.out.println("���� �÷��̾� ���� Ȯ��");
        if (isOn) {
            System.out.println("���� �÷��̾� ON, ����:" + volume);
        } else {
            System.out.println("���� �÷��̾� OFF");
        }
        //���� �÷��̾� ����
        isOn = false;
        System.out.println("���� �÷��̾ �����մϴ�");
    }
}