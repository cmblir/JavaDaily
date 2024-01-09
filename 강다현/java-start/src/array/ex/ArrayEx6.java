package array.ex;

import java.util.Scanner;

public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 받을 숫자의 개수를 입력하세요: ");
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        int minNum, maxNum;

        System.out.println(num + "개의 정수를 입력하세요");
        for(int i=0;i<numbers.length;i++){
            numbers[i] = scanner.nextInt();
        }
        minNum = maxNum = numbers[0];

        for (int number : numbers) {
            if(minNum>number){
                minNum = number;
            }
            if(maxNum<number){
                maxNum = number;
            }

        }
        System.out.println("minNum = " + minNum);
        System.out.println("maxNum = " + maxNum);

    }
}
