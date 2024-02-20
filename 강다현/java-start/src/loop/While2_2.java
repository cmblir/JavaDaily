package loop;
/*
변경되는 부분을 변수 i로 처리함
i의 값만 변경하면 나머지 코드를 전혀 변경하지 않아도 된다.
 */
public class While2_2 {
    public static void main(String[] args) {
        int sum=0;
        int i=1;
        sum = sum +i;
        System.out.println("i = "+ i +", sum = "+sum);
        i++;

        sum = sum +i;
        System.out.println("i = "+ i +", sum = "+sum);
        i++;

        sum = sum +i;
        System.out.println("i = "+ i +", sum = "+sum);
        i++;
    }
}
