import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1; // 현재 몇 번째 기회인지 추적
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            // 1. 점수 처리 (0~10)
            if (Character.isDigit(c)) {
                idx++;
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    scores[idx] = 10;
                    i++; // '0' 부분을 건너뜀
                } else {
                    scores[idx] = c - '0';
                }
            } 
            // 2. 보너스 처리 (S, D, T)
            else if (c == 'S') {
                scores[idx] = (int) Math.pow(scores[idx], 1);
            } else if (c == 'D') {
                scores[idx] = (int) Math.pow(scores[idx], 2);
            } else if (c == 'T') {
                scores[idx] = (int) Math.pow(scores[idx], 3);
            } 
            // 3. 옵션 처리 (*, #)
            else if (c == '*') {
                scores[idx] *= 2;
                if (idx > 0) {
                    scores[idx - 1] *= 2;
                }
            } else if (c == '#') {
                scores[idx] *= -1;
            }
        }
        
        // 세 차례 점수의 총합 반환
        return scores[0] + scores[1] + scores[2];
    }
}