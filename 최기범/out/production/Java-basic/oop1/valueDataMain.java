package oop1;

public class valueDataMain {
    public static void main(String[] args) {
        ValueData valueData = new ValueData();
        add(valueData);
        add(valueData);
        add(valueData);
        System.out.println("���� ����=" + valueData.value);
    }
    static void add(ValueData valueData) {
        valueData.value++;
        System.out.println("���� ���� value=" + valueData.value);
    }
}
