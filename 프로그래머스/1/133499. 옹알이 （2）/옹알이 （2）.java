import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        for(int i=0;i<babbling.length;i++) {
            String lastBab = "";
            String bab = "";
            for(int j=0;j<babbling[i].length();j++) {
                bab += babbling[i].charAt(j);
                if(set.contains(bab) && !lastBab.equals(bab)) {
                    lastBab = bab;
                    bab = "";
                }
            }
            if(bab.equals("")) answer++;
        }
        return answer;
    }
}