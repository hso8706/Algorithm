import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T;
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc < T+1; tc++) {
            bw.write("#" + tc + " ");
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parents = new int[n+1]; // 0번 제외
            makeSet(); // 1~n명 초기화
            int cnt = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int[] temp = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                union(temp[0], temp[1]); // 무리 만들기
            }
            for (int i = 1; i < n+1; i++) {//편의상 1부터 시작, 총 n 번
                parents[i] = find(i);
            }
            for (int i = 1; i < n+1; i++) {
                boolean checker = false;
                for (int j = 1; j < n+1; j++) {
                    if (parents[j] == i){
                        parents[j] = 0;
                        checker = true;
                    }
                }
                if (checker){
                    checker = false;
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);

        if (aroot < broot){
            parents[broot] = aroot;
        }
        else parents[aroot] = broot;
    }

    private static int find(int a) {
        if(parents[a] == a){
            return a;
        }

        return find(parents[a]);
    }

    private static void makeSet() {
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }
    }
}