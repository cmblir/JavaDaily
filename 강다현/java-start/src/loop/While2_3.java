package loop;

public class While2_3 {
    public static void main(String[] args) {
        /*
        i의 범위가 main 이다. 따라서 for2의 코드가 더 구조적으로 깔끔한 것이다.
        (변수를 한정해서 사용할 수 있기 때문이다.)
         */
        int sum=0;
        int i=1;
        int endNum = 3;
        while(i<=endNum){
            sum = sum +i;
            System.out.println("i = "+ i +", sum = "+sum);
            i++;
        }
    }
}
