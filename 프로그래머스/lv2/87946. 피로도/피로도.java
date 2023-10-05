import java.util.*;

class Solution {
    /*
    - answer: 최종 카운트, cnt: 중간 카운트
    - visited 배열을 사용해서 순회할 것.
    */
    public int solution(int k, int[][] dungeons) {
        int answer = k;
        // boolean[] visited = new boolean[dungeons.length];
        
        answer = dfs(0, 0, k, dungeons, new boolean[dungeons.length]);
        
        return answer;
    }
    
    private int dfs(int maxV, int cnt, int k, int[][] dungeons, boolean[] visited){
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                // boolean flag = false;
                if(dungeons[i][0] <= k){
                    k -= dungeons[i][1];
                    cnt++;
                    // flag = true;
                    maxV = dfs(maxV, cnt, k, dungeons, visited);
                    k += dungeons[i][1];
                    cnt--;
                }
                visited[i] = false;
            }
        }
        
        return Math.max(maxV, cnt);
    }
}