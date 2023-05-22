import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    - A * B map
    - 초기 로봇 좌표 (x,y)
    - 로봇은 여러개 : N 개
    - 4방 탐색
    - 명령 순차적 실행 : M개 명령
        - 로봇 인덱스 | 명령 종류 | 명령 반복 횟수
     */
    static class Robo {

        int x;
        int y;
        int d;

        public Robo(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Robo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    '}';
        }
    }

    static class Order {

        int idx;
        String order;
        int rep;

        public Order(int idx, String order, int rep) {
            this.idx = idx;
            this.order = order;
            this.rep = rep;
        }
    }

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int A, B; //가로, 세로
    static int N, M;
    static Robo[] robots;
    static Order[] orders;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robots = new Robo[N + 1];
        orders = new Order[M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = B - (Integer.parseInt(st.nextToken())-1);
            int d = toInt(st.nextToken());

            robots[i] = new Robo(x, y, d);
        }


        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx = Integer.parseInt(st.nextToken());
            String order = st.nextToken();
            int rep = Integer.parseInt(st.nextToken());
            orders[i] = new Order(idx, order, rep);
        }

        flag = true;
        for (int i = 1; i < M + 1; i++) {
            int idx = orders[i].idx;
            String order = orders[i].order;
            int rep = orders[i].rep;
            doRobot(idx, order, rep);
            if(!flag) break;
        }
        if(flag) bw.write("OK");
        bw.flush();
        bw.close();
//        for (int i = 1; i < M+1; i++) {
//            st = new StringTokenizer(bf.readLine());
//            int idx = Integer.parseInt(st.nextToken());
//            String order = st.nextToken();
//            int rep = Integer.parseInt(st.nextToken());
//            orders[i] = new Order(idx, order, rep);
//        }
//
//        for (int i = 1; i < M+1; i++) {
//            doRobot(orders[i]);
//        }
    }

    private static void doRobot(int idx, String order, int rep) throws IOException {
//        orders[i] = new Order(idx, order, rep);

        for (int j = 0; j < rep; j++) {
            switch (order) {
                case "L":
                    robots[idx].d -= 1;
                    if (robots[idx].d < 0) {
                        robots[idx].d = 3;
                    }
                    break;

                case "R":
                    robots[idx].d += 1;
                    if (robots[idx].d > 3) {
                        robots[idx].d = 0;
                    }
                    break;

                case "F":
                    int cd = robots[idx].d;
                    robots[idx].x += dy[cd];
                    robots[idx].y += dx[cd];
                    int cx = robots[idx].x;
                    int cy = robots[idx].y;
                    int otherIdx = isCrushedRobot(cx, cy, idx);
                    if (otherIdx != -1) {
                        bw.write("Robot " + idx + " crashes into robot " + otherIdx);
                        flag = false;
                        return;
                    }
                    if (cx < 1 || cy < 1 || cx > A || cy > B) {
                        bw.write("Robot " + idx + " crashes into the wall");
                        flag = false;
                        return;
                    }
                    break;
            }
        }
        flag = true;
    }

    private static int isCrushedRobot(int cx, int cy, int idx) {
        for (int i = 1; i < robots.length; i++) {
            if (i == idx) {
                continue;
            }
            if (cx == robots[i].x && cy == robots[i].y) {
                return i;
            }
        }
        return -1;
    }

    private static int toInt(String nextToken) {
        switch (nextToken) {
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            case "W":
                return 3;
        }
        return -1;
    }
}