import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        br.close();

        bw.write(String.valueOf(N*N*N));
        bw.write("\n");
        bw.write(String.valueOf(3));
        bw.flush();
        bw.close();
    }
}