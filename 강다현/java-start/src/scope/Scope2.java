package scope;

public class Scope2 {
    public static void main(String[] args) {
        int m = 10;
        for(int i = 0; i< 2; i++){ //블록 내부, for문 내
            System.out.println("for m = "+m); // 블록 내부에서 외부는 접근 가능
            System.out.println("for i = "+i);
        } // i 생존 완료
        /*
        for 문의 i는 외부에서 접근 가능 ( for문 돌아갈때만 유효하다. )
         */
    }
}
