import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] city;
    static ArrayList<int[]> home, store;
    static ArrayList<int[]> storeCombi;
    static int homeSize, storeSize;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        store = new ArrayList<>();
        storeCombi = new ArrayList<>();
        pq = new PriorityQueue<>();

        city = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < N+1; j++) {
                int temp = Integer.parseInt(st.nextToken());
                city[i][j] = temp;
                if(temp == 1) home.add(new int[]{i, j});
                if(temp == 2) store.add(new int[]{i, j});
            }
        }
        homeSize = home.size();
        storeSize = store.size();
        combi(0, 0);
        bw.write(pq.poll() + "\n");
        bw.flush();
        bw.close();
    }

    private static void combi(int cnt, int start) throws IOException {
        if(cnt == M){
            // 치킨 가게 M개 뽑힌 상태
            // 집 좌표 모두 저장된 상태
            minDistance();
            return;
        }
        for (int i = start; i < storeSize; i++) {
            storeCombi.add(store.get(i));
            combi(cnt + 1, i + 1);
            storeCombi.remove(store.get(i));
        }
    }

    private static void minDistance() throws IOException {
        int total = 0;

        // 각 집의 치킨 거리의 합 구하기
        for (int i = 0; i < homeSize; i++) {
            int[] distance = new int[storeCombi.size()];
            for (int j = 0; j < storeCombi.size(); j++) {
                distance[j] = Math.abs(home.get(i)[0] - storeCombi.get(j)[0]) + Math.abs(home.get(i)[1] - storeCombi.get(j)[1]);
            }
            Arrays.sort(distance);
            total += distance[0];
        }
        pq.offer(total);
    }

}
/*
1. 조합을 이용해서 치킨집을 선정, 경우의 수마다 최소 치킨 거리를 구하여 저장하고 그 중에서 최소값 선정
 */