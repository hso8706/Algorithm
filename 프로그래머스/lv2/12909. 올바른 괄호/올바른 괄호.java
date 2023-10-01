import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(deque.isEmpty()) deque.offer(c);
            else {
                if(deque.peekLast() == ')') return false;
                else {
                    if(c == ')') deque.pollLast();
                    else deque.offerLast(c);
                }
            }
        }

        return deque.isEmpty();
    }
}