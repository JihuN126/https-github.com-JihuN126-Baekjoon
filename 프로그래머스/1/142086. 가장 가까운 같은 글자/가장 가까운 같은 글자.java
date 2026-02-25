import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c = 'a';c<='z';c++) {
            map.put(c,-1);
        }
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int result = map.get(c);
            // System.out.println(result);
            if(result==-1) {
                answer[i] = map.get(c);
                map.put(c, i);
            }
            else {
                // System.out.println("i : " + i);
                answer[i] = i-map.get(c);
                map.put(c,i);
                // System.out.println("map.get(c) : " + map.get(c));
                // System.out.println("map.get(c) : " + map.get(c));
            }
            
        }
        return answer;
    }
}