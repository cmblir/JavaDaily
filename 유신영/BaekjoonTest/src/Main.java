import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = i + 1;
        }

        for (int m = 0; m < M; m++) {
            String[] temp = br.readLine().split(" ");
            int i = Integer.parseInt(temp[0]);
            int j = Integer.parseInt(temp[1]);
            if (i < j) {
                for (int jm = j-1, im = i-1; jm > im; jm--, im++) {
                    int tempInt = answer[jm];
                    answer[jm] = answer[im];
                    answer[im] = tempInt;
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}