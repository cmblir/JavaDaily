package cond;
/*
자바14부터 등장한 새로운 switch문
앞으로 점점 더 많이 사용할 것이다.
     -> 를 사용한다
     선택된 데이터를 반환할 수 있다.
 */
public class Switch4 {
    public static void main(String[] args) {
        int grade =2;
        int coupon = switch(grade){
            case 1-> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default ->500;
        };
        System.out.println("발급받은 쿠폰 "+ coupon);
    }
}
