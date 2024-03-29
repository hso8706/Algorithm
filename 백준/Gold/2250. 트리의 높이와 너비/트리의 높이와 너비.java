import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.Icon;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    - dfs 방식으로 설계할 것
    - 2차원으로 입력 받아도 될 듯 함.
     */
    static int N;
    static int[][] trees;
    static int[] cnt;
    static ArrayList<Integer>[] width;
    static boolean[] visited;
    static int root;
    static int ll;
    public static void main(String[] args) throws IOException {

        init();
        dfs(root, 1);
        output();
    }

    private static void output() throws IOException {
        int maxD = 0;
        int maxW = 0;
        for (int i = 1; i < N+1; i++) {
            if(width[i].size()==0) continue;
            int w = Math.abs(width[i].get(0) - width[i].get(width[i].size()-1))+1;
            if(w > maxW){
                maxD = i;
                maxW = w;
            }
        }
        bw.write(maxD + " " + maxW);
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int x) {
        if(idx == -1){
            return;
        }

        dfs(trees[idx][0], x+1);
        ll++;
        width[x].add(ll);
        visited[idx] = true;
        dfs(trees[idx][1], x+1);
        if(!visited[idx]) {
            ll++;
            width[x].add(ll);
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bf.readLine());
        trees = new int[N+1][2];
        cnt = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            trees[idx][0] = left;
            trees[idx][1] = right;
            cnt[idx]++;
            if(left!=-1) cnt[left]++;
            if(right!=-1) cnt[right]++;
        }
        for (int i = 1; i < N+1; i++) {
            if(cnt[i]!=2) root = i;
        }
        width = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            width[i] = new ArrayList<>();
        }
        ll = 0;
    }
}