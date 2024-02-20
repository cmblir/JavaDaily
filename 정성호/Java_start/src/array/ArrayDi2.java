package array;

public class ArrayDi2 {
    public static void main(String[] args) {
        int row = 2, col = 3;
        int[][] arr = new int[row][col];
        int start = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++, start++) {
                arr[i][j] = start;
                System.out.println(arr[i][j]);
            }
        }

    }
}
