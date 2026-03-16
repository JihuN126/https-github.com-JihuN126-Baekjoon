import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> que = new LinkedList<>();
        int lastNum = -1;
        for(int i : arr) {
            if(que.isEmpty()) {
                que.add(i);
                lastNum = i;
                continue;
            }
            
            if(lastNum==i) continue;
            que.add(i);
            lastNum=i;
        }
        int[] answer = new int[que.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = que.poll();
        }
        return answer;
    }
}