
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.StringTokenizer;

class Solution {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        //달팽이 길찾기
        //입력 1: T
            // testCase
        //입력 2: N
            // N * N 달팽이
            // 1 <= N <= 10
        //N * N 빈 배열 생성
            //달팽이 빈 공간 생성

        //concept
        //1, -1 이라는 방향 변수를 지정하여 좌표를 이동하게 함
        //좌표를 이동하며 1씩 늘어감
        //직진으로 진행할 변의 갯수 == (2*n - 1)
            // 1개를 먼저 진행시키고 n번의 반복문 실행
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(bf.readLine());
            int NPrint = N;
            int[][] snail = new int[N][N];
            int x = 0;
            int y = -1;
            int direction = 1;
            int num = 1; // 칸에 할당될 값

            while (N > 0){ // N번의 반복문 실행
                //가장 첫 변 먼저 실행
                for (int i = 0; i < N; i++) { // 변의 길이만큼 반복
                    y += direction;
                    snail[x][y] = num;
                    num++;
                }
                N -= 1;
                for (int i = 0; i < N; i++) {
                    x += direction;
                    snail[x][y] = num;
                    num++;
                }
                direction *= -1;
            }
            bw.write("#"+tc+"\n");
            for (int i = 0; i < NPrint; i++) {
                for (int j = 0; j < NPrint; j++) {
                    bw.write(snail[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
        }
        bw.close();
    }
}
