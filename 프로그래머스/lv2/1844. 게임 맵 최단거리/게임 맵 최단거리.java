import java.util.*;

class Solution {
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cx = c[0];
            int cy = c[1];
            int cc = c[2];
            if(cx == n-1 && cy == m-1) {
                answer = cc;
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nc = cc + 1;
                if(nx<0 || ny<0 || nx>=n || ny>=m || maps[nx][ny] == 0) continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny,nc});
                }
            }
        }
        
        return answer == 1 ? -1 : answer;
    }
}