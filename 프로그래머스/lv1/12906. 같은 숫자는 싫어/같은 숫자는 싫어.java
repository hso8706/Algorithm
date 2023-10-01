import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(deque.peekLast() != arr[i]) deque.offerLast(arr[i]);
        }
        answer = new int[deque.size()];
        
        int idx = 0;
        while(!deque.isEmpty()){
            answer[idx] = deque.pollFirst();
            idx++;
        }

        return answer;
    }
}