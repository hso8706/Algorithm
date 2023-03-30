import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    /*

    우, 하 로만 이동 => visited 필요 없음 => 실수
    - visited 필요함, 최소 비용으로 가기 위해선 역으로 갈 수 도 있음.
     */
    static int N;
    static int[][] cave;
    static int[][] sumRupee;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int tc = 1;
        while (true) {
            N = Integer.parseInt(bf.readLine());
            if (N == 0) break;
            cave = new int[N][N];
            sumRupee = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    sumRupee[i][j] = Integer.MAX_VALUE;
                }
            }
            sumRupee[0][0] = cave[0][0];
            makeSumRupeeBFS(new Pair(0,0));
            bw.write("Problem " + tc + ": " + sumRupee[N - 1][N - 1] + "\n");
            tc++;
        }
        bw.flush();
        bw.close();
    }

    private static void makeSumRupeeBFS(Pair start) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) { // x가 세로
            Pair current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                int ns = sumRupee[cx][cy] + cave[nx][ny];
                if (ns < sumRupee[nx][ny]) {
                    sumRupee[nx][ny] = ns;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }
}