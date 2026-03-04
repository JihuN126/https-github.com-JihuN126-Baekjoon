import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> Que = new PriorityQueue<>();
        for(int i=0;i<score.length;i++) {
            Que.add(score[i]);
            if(i+1 > k) {
                Que.poll();
                answer[i] = Que.peek();      
            }
            else {
                answer[i] = Que.peek();
            }
        }
        return answer;
    }
}