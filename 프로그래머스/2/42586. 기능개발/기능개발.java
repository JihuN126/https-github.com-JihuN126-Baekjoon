import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int remain[] = new int[speeds.length];
        
        for(int i=0; i<remain.length; i++) {
            int remainDay = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) remainDay++;
            remain[i] = remainDay;
        }

        int count = 1;
        int prevDay = remain[0]; 

        for(int i=1; i<remain.length; i++) {
            int day = remain[i];

            if(prevDay >= day) {
                count++;
            } else {
                list.add(count);
                count = 1;
                prevDay = day;
            }
        }
        list.add(count);
    
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    
    }
}