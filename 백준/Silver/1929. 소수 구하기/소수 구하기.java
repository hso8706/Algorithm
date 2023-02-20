import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int M, N;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int num = M; num <= N; num++) {
            if(isPrime(num)) {
                bw.write(num + "\n");
            }
        }
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

    //기본 알고리즘
//    private static boolean isPrime(int num) {
//        for (int j = 2; j < num; j++) {
//            if(num % j == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}