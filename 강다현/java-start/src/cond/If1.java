package cond;

public class If1 {
    public static void main(String[] args) {
        int age = 20; //사용자 나이
        if(age>=18){
            System.out.println("성인입니다.");
        }
        //조건을 만족하지 않으면, if문 안의 블록을 실행하지 않는다.
        if(age<18){
            System.out.println("미성년자입니다.");
        }


    }
}
