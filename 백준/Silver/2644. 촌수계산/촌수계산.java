import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    - 1촌 : 부모 자식

    - 사람 수: n
    - 촌수 계산해야하는 사람 2명
    - 촌수 관계의 개수: m
    - 부모 자식 관계 ~

    -
       */
    static int N, M;
    static int S, E;
    static List<Integer>[] relation;
    static int cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        relation = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            relation[i] = new ArrayList<>();
        }
        M = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            relation[l].add(r);
            relation[r].add(l);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        visited = new boolean[N+1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{S, 0});
        visited[S] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cc = current[1];
            if(cx == E) return cc;
            for (int vertex : relation[cx]) {
                if(!visited[vertex]){
                    visited[vertex] = true;
                    queue.offer(new int[]{ vertex, cc + 1 });
                }
            }

        }
        return -1;
    }
}