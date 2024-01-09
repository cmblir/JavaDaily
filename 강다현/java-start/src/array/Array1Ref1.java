package array;

public class Array1Ref1 {
    public static void main(String[] args) {
        int[] students; // 1. 배열 변수 선언 ( 배열을 담을 수 있는 변수 ) int[] students와 같은 배열 변수에는 배열을 담을 수 있다. (배열 변수에는 10,20 같은 값이 아니라, 배열이라는 것을 담을 수 있다. )
        students = new int[5]; //2. 배열 생성 - int형 변수 5개를 다룰 수 있는 배열을 새로 만든다는 뜻
        //배열 초기화 - 자바는 배열을 생성할 때 그 내부 값을 자동으로 초기화 한다. 숫자는 0, boolean은 false, String은 null로 초기화 된다.
        /*
        배열을 생성하면 배열의 크기만큼 메모리를 확보한다.
        int형 5개를 사용하면 4byte * 5 -> 20byte를 확보한다.
        배열을 생성하고 나면 자바는 메몰 어딘가에 있는 이 배열에 접근할 수 있는 참조값(주소)을 반환한다.
        따라서 변수는 참조값을 가지고 있고, 참조값을 통해 배열을 참조할 수 있다.
        참고로 new int[5] 자체에는 아무런 이름이 없다. 그냥 int 형 변수를 5개 연속으로 만드는 것이고,
        참조형은 배열 변수에 보관하는 것이다.

        즉 배열을 사용하면 참조값을 통해서 실제 배열에 접근하고, 인덱스를 통해 원하는 요소를 찾는다.
         */
        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        //변수 값 사용
        System.out.println("student1 = " + students[0]);
        System.out.println("student2 = " + students[1]);
        System.out.println("student3 = " + students[2]);
        System.out.println("student4 = " + students[3]);
        System.out.println("student5 = " + students[4]);
    }
}
