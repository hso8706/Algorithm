import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();
        for(String[] sh : clothes){
            if(!hash.containsKey(sh[1])) hash.put(sh[1], 1);
            else hash.put(sh[1], hash.get(sh[1])+1);
        }
        // System.out.println(hash);
        for(String key : hash.keySet()){
            answer *= (hash.get(key)+1);
        }
        
        return answer-1;
    }
}