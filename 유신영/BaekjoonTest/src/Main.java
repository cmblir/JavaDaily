import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        br.close();

        ArrayList<Character> list = new ArrayList<>();
        while (N > 0) {
            if (N % B < 10) {
                list.add((char) (N % B + '0'));
            }
            else{
                list.add((char) (N % B - 10 + 'A'));
            }
            N /= B;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i));
        }
        bw.flush();
        bw.close();
    }
}