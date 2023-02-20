import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int M, N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if(isPrime(Integer.parseInt(st.nextToken()))) {
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    //제곱근 알고리즘
    private static boolean isPrime(int num) {
        if(num == 1) return false;
        if(num == 2) return true;

        for (int j = 2; j <= Math.sqrt(num); j++) {
            if(num % j == 0) {
                return false;
            }
        }
        return true;
    }
}