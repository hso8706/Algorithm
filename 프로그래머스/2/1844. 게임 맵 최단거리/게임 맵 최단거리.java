import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;
        
        public Node (int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo (Node o){
            return this.x - o.x;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        //초기화
        visited = new boolean[maps.length][maps[0].length];
        //bfs 진행
        answer = bfs(0,0,maps.length-1,maps[0].length-1,maps);
        return answer;
    }
    
    public int bfs(int sx, int sy, int ex, int ey, int[][] maps){
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(sx, sy,1));
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()){
            Node c = queue.poll();
            int cx = c.x;
            int cy = c.y;
            int cc = c.cnt;
            if(cx == ex && cy == ey){
                return cc;
            }
            
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nc = cc + 1;
                if(nx<0 || ny<0 || nx>ex || ny>ey || maps[nx][ny] == 0)continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, nc));
                }
            }
        }
        return -1;
    }
}