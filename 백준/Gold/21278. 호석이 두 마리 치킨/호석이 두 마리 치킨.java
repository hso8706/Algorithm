import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    - 2개 설정 후 개별 다익스트라
     */
    static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, M;
    static ArrayList<Node>[] adjList;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
    static int[] nums;
    static int[] selected;
    static int A, B, W;
    public static void main(String[] args) throws IOException {

        init();
        selectTwo(0,1);
        System.out.println(A+" "+B+" "+W);
    }
    //combination
    private static void selectTwo(int cnt, int start) {
        if(cnt==2){
            dist = new int[2][N+1];
            for (int i = 0; i < 2; i++) {
                Arrays.fill(dist[i], INF);
                dijkstra(selected[i], i);
//                System.out.println(selected[i]+": ["+i+"]"+Arrays.toString(dist[i]));
            }
            int sum = 0;
            int a = 0;
            int b = 0;
            for (int i = 1; i < N+1; i++) {
                if(dist[0][i]==0) {
                    a = i;
                    continue;
                }
                else if (dist[1][i] == 0){
                    b = i;
                    continue;
                }
                int minValue = Math.min(dist[0][i], dist[1][i]);
                sum += minValue*2;
            }
            if(sum != 0 && sum < W){
                A = a;
                B = b;
                W = sum;
            }
//            System.out.println();
            return;
        }

        for (int i = start; i < nums.length; i++) {
            selected[cnt] = nums[i];
            selectTwo(cnt+1, i+1);
        }
    }

    private static void dijkstra(int start, int idx) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 다익스트라 - PQ
        boolean[] visited = new boolean[N+1];
        pq.offer(new Node(start,0)); // 시작 지점
        dist[idx][start] = 0; // 시작 지점 최소 거리 0

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(visited[current.node]) continue; // 방문 처리 된 곳 패스
            visited[current.node] = true; // 현재 지점만 방문 처리

            for(Node next : adjList[current.node]){
                if(!visited[next.node] && dist[idx][next.node] > dist[idx][current.node] + next.weight){
                    dist[idx][next.node] = dist[idx][current.node] + next.weight;
                    pq.add(new Node(next.node, dist[idx][next.node]));
                }
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, 1));
            adjList[b].add(new Node(a, 1));
        }

        nums = new int[N+1];
        selected = new int[2];
        for (int i = 1; i < N+1; i++) {
            nums[i] = i;
        }
        A=B=0;
        W= Integer.MAX_VALUE;
    }

}