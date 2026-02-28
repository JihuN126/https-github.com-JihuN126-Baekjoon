import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        
        for(char x : X.toCharArray()) xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        for(char y : Y.toCharArray()) yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        
        for(int i = 9; i >= 0; i--) {
            char target = (char)(i + '0');
            int xCount = xMap.getOrDefault(target, 0); 
            int yCount = yMap.getOrDefault(target, 0);
            
            int commonCount = Math.min(xCount, yCount);
            
            for(int j = 0; j < commonCount; j++) {
                sb.append(target);
            }
        }
        
        String answer = sb.toString();
        
        if (answer.isEmpty()) return "-1";
        if (answer.startsWith("0")) return "0";
        
        return answer;
    }
}