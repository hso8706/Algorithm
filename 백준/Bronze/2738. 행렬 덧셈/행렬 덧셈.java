import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] arrA, arrB;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrA = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arrB = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
//                arrB[i][j] = arrA[i][j] + Integer.parseInt(st.nextToken());
//                arrB[i][j] = Integer.parseInt(st.nextToken());
                bw.write(arrA[i][j] + Integer.parseInt(st.nextToken()) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();


    }
}