import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, n, k;
    static int[][] houses;
    public static void main(String[] args) throws IOException {
        //배열 생성
        houses = new int[15][15];
        //0층 초기화
        for (int i = 0; i < 15; i++) {
            houses[0][i] = i;
        }
        //전체 층 초기화
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                houses[i][j] = houses[i][j-1] + houses[i-1][j];
            }
        }
        //입력
        T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            k = Integer.parseInt(bf.readLine());
            n = Integer.parseInt(bf.readLine());
            //출력
            bw.write(houses[k][n]+"\n");
        }
        bw.flush();
        bw.close();

    }

}