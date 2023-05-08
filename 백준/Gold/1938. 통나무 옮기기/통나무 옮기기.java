import java.io.*;
    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Deque;
    import java.util.StringTokenizer;

    public class Main {
        static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static StringTokenizer st;

        /*
        ### 기둥 옮기기
        - 기둥 길이 3
        - 기둥을 밀거나 회전시켜서 목적지에 가져다 둘 수 있는 최소 동작 횟수 출력
        - 출발지 "BBB", 목적지 "EEE"
        - 기둥은 가로, 세로만 가능(대각선 불가)
        - map에서 장애물은 1로 표시되고, 1이 있을 경우 이동 및 회전 불가
        - 회전은 항상 중심점을 기준으로 90도 회전

        - 회전
            - 중심을 기준으로 8방 탐색 후 1이 있거나 map 바깥이면 불가능
        - 이동
            - 회전과 마찬가지
        - bfs
            - 현재 위치에서 (4방 이동 + 회전) 실시 후 queue 저장
         */
        static class Pair {
            int x;
            int y;
            int dir; // 0: 세로, 1: 가로
            int cnt;

            public Pair(int x, int y, int dir, int cnt) {
                this.x = x;
                this.y = y;
                this.dir = dir;
                this.cnt = cnt;
            }
        }
        //4방
        static int[] dx = new int[]{-1,0,1,0};
        static int[] dy = new int[]{0,1,0,-1};
        //8방
        static int[] ex = new int[]{-1,-1,0,1,1,1,0,-1};
        static int[] ey = new int[]{0,1,1,1,0,-1,-1,-1};
        static int N;
        static int[][] map;
        static boolean[][][] visited; // 가로, 세로 따로
        public static void main(String[] args) throws IOException {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            visited = new boolean[2][N][N];
            int ScenterCnt = 0;
            int EcenterCnt = 0;
            Pair end = null;
            Pair start = null;
            for (int i = 0; i < N; i++) {
                String[] temp = bf.readLine().split("");
                for (int j = 0; j < N; j++) {
                    if(temp[j].equals("B")) {
                        map[i][j] = 2; // 시작점 2
                        ScenterCnt++;
                        if (ScenterCnt == 2) {// 기둥 중점
                            int dir = -1;
                            if(i!=0 && map[i-1][j]==2) dir = 0;
                            else if(j!=0 && map[i][j-1]==2) dir = 1;
                            start = new Pair(i, j, dir,0);
                        }
                    }
                    else if(temp[j].equals("E")) {
                        map[i][j] = 3; // 도착점 3
                        EcenterCnt++;
                        if (EcenterCnt == 2) {// 기둥 중점
                            int dir = -1;
                            if(i!=0 && map[i-1][j]==3) dir = 0;
                            else if(j!=0 && map[i][j-1]==3) dir = 1;
                            end = new Pair(i, j, dir,0);
                        }
                    }
                    else map[i][j] = Integer.parseInt(temp[j]);
                }
            }
    //        System.out.println(start.x+" "+ start.y+" "+ start.dir);
    //        System.out.println(end.x+" "+ end.y+" "+ end.dir);
            int cnt = bfs(start, end);
            System.out.println(cnt);
        }

        private static int bfs(Pair start, Pair end) {
            Deque<Pair> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start.dir][start.x][start.y] = true;

            while(!queue.isEmpty()){
                Pair current = queue.poll();
                int cx = current.x;
                int cy = current.y;
                int cd = current.dir;
                int cnt = current.cnt;
                if(cx == end.x && cy == end.y && cd == end.dir){
                    return cnt;
                }

                for (int i = 0; i < 5; i++) { // 중점: 4방 이동 + 회전
                    if(i==4){ // 회전
                        int nd = cd==0 ? 1 : 0;
                        if(!visited[nd][cx][cy]) {
                            boolean safeCheck = true;
                            if (cd == 0) { // 세로->가로
                                for (int j = 0; j < 8; j++) {//8방
                                    if (j == 0 || j == 4) continue;
                                    int nnx = cx + ex[j];
                                    int nny = cy + ey[j];
                                    if (nnx < 0 || nny < 0 || nnx >= N || nny >= N || map[nnx][nny] == 1) {
                                        safeCheck = false;
                                        break;
                                    }
                                }
                            } else { // 가로->세로
                                for (int j = 0; j < 8; j++) {//8방
                                    if (j == 2 || j == 6) continue;
                                    int nnx = cx + ex[j];
                                    int nny = cy + ey[j];
                                    if (nnx < 0 || nny < 0 || nnx >= N || nny >= N || map[nnx][nny] == 1) {
                                        safeCheck = false;
                                        break;
                                    }
                                }
                            }
                            if (safeCheck) {
                                queue.offer(new Pair(cx, cy, nd, cnt+1));
                            }
//                            visited[nd][cx][cy] = true;
                        }
                    }
                    else {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];
                        if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny] == 1) continue;
                        if(!visited[cd][nx][ny]){
                            boolean safeCheck = true;
                            if(cd == 0){ // 세로
                                if(i==0 || i==2){
                                    int nnx = nx + dx[i];
                                    int nny = ny + dy[i];
                                    if(nnx<0 || nny<0 || nnx>=N || nny>=N || map[nnx][nny] == 1) {
                                        safeCheck = false;
                                        continue;
                                    }
                                }
                                else {
                                    for (int j = 0; j < 8; j++) {//8방
                                        if(j==0 || j==4) {
                                            int nnx = nx + ex[j];
                                            int nny = ny + ey[j];
                                            if (nnx < 0 || nny < 0 || nnx >= N || nny >= N || map[nnx][nny] == 1) {
                                                safeCheck = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            else { // 가로
                                if(i==1 || i==3){
                                    int nnx = nx + dx[i];
                                    int nny = ny + dy[i];
                                    if(nnx<0 || nny<0 || nnx>=N || nny>=N || map[nnx][nny] == 1) {
                                        safeCheck = false;
                                        continue;
                                    }
                                }
                                else{
                                    for (int j = 0; j < 8; j++) {//8방
                                        if(j==2 || j==6) {
                                            int nnx = nx + ex[j];
                                            int nny = ny + ey[j];
                                            if (nnx < 0 || nny < 0 || nnx >= N || nny >= N || map[nnx][nny] == 1) {
                                                safeCheck = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            if(safeCheck) queue.offer(new Pair(nx, ny, cd, cnt+1));
                            visited[cd][nx][ny] = true;
                        }
                    }
                }
            }
            return 0;
        }
    }