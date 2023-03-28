import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    아이디어1. => 시간 초과
    1. 값이 1인곳의 좌표를 받아 인덱스로 저장 => 최대 1000 * 1000
    2. 해당 인덱스를 순회하며 벽 하나씩 허물어보기
    3. 2에 이어서 허문 상태의 맵을 bfs 순회
    4. 2, 3을 반복해서 최소 경로 갱신

    아이디어2. => 실패
    1. 벽을 부실 수 있는 횟수를 카운트하며 bfs
    + 주의사항 : 1을 깬 후 사방탐색으로 0인 공간을 간 경우와, 그냥 0에서 0으로 갈 때가 겹치는 길에서 문제 발생
    
    아이디어 3. => 메모리 초과
    1. 아이디어2 + visited 추가
    - 2개의 visited를 만든다
    - cb == 0, 1 일때의 경우를 나누어 visited 체크
     */
    static int N, M; // 맵 크기
    static int[][] map;
    static boolean[][][] visited;
//    static boolean[][] visitedBroken;
    //        static int[][] walls;
    static int minRoute;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[2][N + 1][M + 1];
//        visitedBroken = new boolean[N + 1][M + 1];
        minRoute = Integer.MAX_VALUE;

        for (int i = 1; i < N + 1; i++) {
            String[] temp = bf.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }
        bfs(1, 1, 1, 1);

        minRoute = minRoute == Integer.MAX_VALUE ? -1 : minRoute;
        bw.write(minRoute + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y, int cnt, int canBreak) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, cnt, 0});
        visited[0][x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cc = current[2];
            int cb = current[3];
            if (cx == N && cy == M) {
                minRoute = Math.min(minRoute, cc);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (!visited[0][nx][ny]) {
                    if (cb == 0){
                        if (map[nx][ny] == 1) {
                            visited[1][nx][ny] = true;
                            queue.offer(new int[]{nx, ny, cc + 1, cb+1});
                        }
                        if (map[nx][ny] == 0){
                            visited[0][nx][ny] = true;
                            queue.offer(new int[]{nx, ny, cc + 1, cb});
                        }
                    }
                    else if(cb == 1){
                        if(map[nx][ny] == 0 && !visited[1][nx][ny]) {
                            visited[1][nx][ny] = true;
                            queue.offer(new int[]{nx, ny, cc + 1, cb});
                        }
                    }
//                    if (cb == 0 && map[nx][ny] == 1) {
//                        map[nx][ny] = 0;
//                        visited[nx][ny] = true;
//                        System.out.println(nx +"," + ny +"," + cb+ ": break");
//                        for (int j = 0; j < N+1; j++) {
//                            System.out.println(Arrays.toString(map[j]));
//                        }
//                        System.out.println();
//                        queue.offer(new int[]{nx, ny, cc + 1, cb+1});
//                        map[nx][ny] = 1; // 복구 작업 때문에 offer 작업 분리
//                    }
//                    else if(map[nx][ny] == 0) {
//                        visited[nx][ny] = true;
//                        queue.offer(new int[]{nx, ny, cc + 1, cb});
//                        System.out.println(nx +"," + ny +"," + cb);
//                        for (int j = 0; j < N+1; j++) {
//                            System.out.println(Arrays.toString(map[j]));
//                        }
//                        System.out.println();
//                    }
                }
            }
        }
    }
}