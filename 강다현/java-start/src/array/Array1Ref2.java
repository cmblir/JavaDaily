package array;

public class Array1Ref2 {
    public static void main(String[] args) {
        int[] students; // 1. 배열 변수 선언 ( 배열을 담을 수 있는 변수 ) int[] students와 같은 배열 변수에는 배열을 담을 수 있다. (배열 변수에는 10,20 같은 값이 아니라, 배열이라는 것을 담을 수 있다. )
        students = new int[5]; //2. 배열 생성 - int형 변수 5개를 다룰 수 있는 배열을 새로 만든다는 뜻

        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        //변수 값 사용
        for(int i=0;i< students.length;i++){
            System.out.println("학생"+(i+1)+"점수 : "+students[i]);
        }
    }
}
