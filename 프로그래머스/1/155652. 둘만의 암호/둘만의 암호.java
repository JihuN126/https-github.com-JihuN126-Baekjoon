import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int sLength = s.length();

        for (int i = 0; i < s.length(); i++) {
        char curr = s.charAt(i);
        int step = 0;

        while (step < index) {
            curr++;
            if (curr > 'z') curr = 'a'; 


            if (skip.indexOf(curr) == -1) {
                step++;
            }
        }
        answer += curr;
    }
        return answer;
    }
}