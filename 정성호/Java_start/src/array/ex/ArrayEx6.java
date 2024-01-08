package array.ex;

import java.util.Scanner;

public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요 : ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println(length + "개의 정수를 입력하세요 : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        /* 선택정렬
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
         */
        int minIndex, maxIndex;
        minIndex = maxIndex = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minIndex) {
                minIndex = arr[i];
            } else if (arr[i] > maxIndex) {
                maxIndex = arr[i];
            }
        }

        System.out.println("가장 작은 정수 : " + minIndex);
        System.out.println("가장 큰 정수 : " + maxIndex);
    }
}
