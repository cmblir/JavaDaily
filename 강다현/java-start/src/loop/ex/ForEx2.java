package loop.ex;

public class ForEx2 {
    public static void main(String[] args) {
        int num =2;
        for(int count =1;count<=10;count++){ //카운트 변수 정의, 증감 하는 것이 깔끔
            System.out.println(num);
            num+=2;
        }
    }
}
