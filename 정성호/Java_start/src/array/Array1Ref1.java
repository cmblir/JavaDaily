package array;

public class Array1Ref1 {
    public static void main(String[] args) {
        int[] students;
        students = new int[5]; // 0~4 5개짜리 배열 생성
        System.out.println(students);
        /*
        I@a09ee92 라는 배열 변수의 값이 나오는데
        I는 int형 배열, a09ee92는 메모리 참조값(주소값) 16지수이다.
        자바는 접근 방법이 참조값 -> 배열 접근 -> 출력이다.
         */

        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);
        System.out.println(students[4]);
    }
}
