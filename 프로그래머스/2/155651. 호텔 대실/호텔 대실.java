import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int minuteTime[][] = new int[book_time.length][2];
        for(int i=0;i<minuteTime.length;i++) {
            minuteTime[i][0] = Time(book_time[i][0]);
            minuteTime[i][1] = Time(book_time[i][1]) + 10;
        }
        Arrays.sort(minuteTime, (o1,o2) -> o1[0]-o2[0]);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int[] arr : minuteTime) {
            int start = arr[0];
            int end = arr[1];
            
            if(!que.isEmpty() && que.peek() <= start) {
                que.poll();
            }
            que.add(end);
        }
        return que.size();
    }
    public int Time(String str) {
        String[] s = str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}