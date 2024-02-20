package cond;
/*
switch 는 단순히 값만 넣는 것 가능 (문자도 가능)
if문이 조금더 큰 개념
 */
public class Switch3 {
    public static void main(String[] args) {
        int grade =2;
        int coupon;

        switch(grade){
            case 1:
                coupon = 1000;
                break;
            case 2: //2등급과 3등급은 똑같이 coupon 3000원
            case 3:
                coupon =3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("발급받은 쿠폰 "+ coupon);
    }
}
