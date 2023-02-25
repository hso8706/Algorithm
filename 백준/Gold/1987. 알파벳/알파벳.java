import java.io.*;
    import java.lang.reflect.Array;
    import java.util.*;

    public class Main {
        static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static StringTokenizer st;
        static StringBuilder sb;

        static int R, C; //R: 세로, C: 가로
        static String[][] board; //R x C
        static String visited;
        static ArrayList<Integer> move;
        static int maxRoute;
        static int[] dx = new int[]{-1, 0, 1, 0};//상우하좌
        static int[] dy = new int[]{0, 1, 0, -1};

        public static void main(String[] args) throws IOException {
            st = new StringTokenizer(bf.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new String[R][C];
            visited = "";
            maxRoute = Integer.MIN_VALUE;
            sb = new StringBuilder();
            move = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                String[] temp = bf.readLine().split("");
                for (int j = 0; j < C; j++) {
                    board[i][j] = temp[j];
                }
            }
            canMove(0, 0);
            move.sort(Comparator.reverseOrder());
//            bw.write(move.get(0)+"");
            bw.write(maxRoute+"");
            bw.flush();
            bw.close();
        }

        private static void canMove(int x, int y) {
            if(sb.toString().contains(board[x][y])) {
//                move.add(sb.length());
                if(maxRoute < sb.length()) maxRoute = sb.length();
                return;
            }

//            visited += board[x][y];
            sb.append(board[x][y]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                canMove(nx, ny);
            }
//            visited = visited.substring(0, visited.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }