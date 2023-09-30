import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) throws IOException {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        // System.out.println(map);
        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    System.out.println(phone_book[i]);
                    return false;
                }
            }
        }
        return answer;
    }
}