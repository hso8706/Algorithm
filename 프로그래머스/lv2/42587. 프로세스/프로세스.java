import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> order = new ArrayDeque<>();
        Deque<Integer> pro = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            order.offerLast(i);
            pro.offerLast(priorities[i]);
        }
        
        while(!pro.isEmpty()){
            int tempPro = pro.pollFirst();
            int tempOrder = order.pollFirst();
            boolean flag = false;
            for(int i=0; i<pro.size(); i++){
                if(pro.peekFirst() > tempPro) flag = true;
                pro.offerLast(pro.pollFirst());
            }
            
            if(flag) {
                pro.offerLast(tempPro);
                order.offerLast(tempOrder);
            }
            else result.offerLast(tempOrder);
        }
        int cnt = 1;
        while(!result.isEmpty()){
            if(result.pollFirst() == location) answer = cnt;
            cnt++;
        }
        return answer;
    }
}