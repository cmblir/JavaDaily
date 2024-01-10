package src.array;

public class ArrayDi1 {
    public static void main(String[] args) {

//        int[][] arr = new int[2][3];
//         2 x 3 2차원 배열 생성

//        int start = 1;
//        for(int i = 0; i < 2 ; i++) {
//            for (int j = 0 ; j < 3 ; j++) {
//                arr[i][j] = start++;
//            }
//        }


        int[][] arr = new int[][]{
                {1,2,3},
                {4,5,6}
        };



        for(int i = 0; i < 2; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                System.out.println(arr[i][j]);
            }
        }

    }
}
