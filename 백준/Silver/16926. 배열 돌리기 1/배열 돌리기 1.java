import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, R;
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(board[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    private static void rotate() {
        int boundary = Math.min(N, M) / 2;

        for (int i = 0; i < boundary; i++) {
            int x = i;
            int y = i;
            int temp = board[x][y];
            int idx = 0;
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if(nx<i || ny<i || nx>=N-i || ny>=M-i) {
                    idx++;
                    continue;
                }
                if(nx == i && ny == i) {
                    board[x][y] = temp;
                    break;
                }
                board[x][y] = board[nx][ny];
                x = nx;
                y = ny;

            }
        }
    }
}