import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] restProgresses = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            double place = (double)(100 - progresses[i])/speeds[i];
            int rest = (100 - progresses[i])/speeds[i];
            if((10*place - 10*rest) > 0) rest += 1;
            restProgresses[i] = rest;
        }
        // System.out.println(Arrays.toString(restProgresses));
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        int flag = restProgresses[0];
        for(int i=1; i<restProgresses.length; i++){
            if(flag >= restProgresses[i]) deque.offerLast(deque.pollLast()+1);
            else {
                flag = restProgresses[i];
                deque.offerLast(1);
            }
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