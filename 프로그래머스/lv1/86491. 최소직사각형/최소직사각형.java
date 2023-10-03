import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int top0 = Integer.MIN_VALUE;
        int top1 = Integer.MIN_VALUE;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if(top0 < sizes[i][0]) top0 = sizes[i][0];
            if(top1 < sizes[i][1]) top1 = sizes[i][1];
        }
        answer = top0 * top1;
        return answer;
    }
}