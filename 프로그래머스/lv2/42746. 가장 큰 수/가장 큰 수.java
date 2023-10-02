import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] sorted = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            sorted[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(sorted, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if(sorted[0].equals("0")) return "0";

        for (int i = 0; i < sorted.length; i++) {
            answer.append(sorted[i]);
        }

        return answer.toString();
    }
}