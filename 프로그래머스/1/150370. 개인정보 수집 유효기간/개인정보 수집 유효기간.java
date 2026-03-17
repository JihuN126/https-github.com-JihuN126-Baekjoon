import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<terms.length;i++) {
            String[] split = terms[i].split(" ");
            map.put(split[0], Integer.parseInt(split[1])*28);
        }
        int[] totalDays = new int[privacies.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        String[] todaySplit = today.split("\\.");
        int todayYear = Integer.parseInt(todaySplit[0]);
        int todayMonth = Integer.parseInt(todaySplit[1]);
        int todayDay = Integer.parseInt(todaySplit[2]);
        
        int totalTodayDays = todayDay + (28 * (todayMonth-1)) + ((todayYear-1) * 12 * 28);
        
        int count = 0;
        for(int i=0;i<totalDays.length;i++) {
            
            String[] split = privacies[i].split(" ");
            String[] ymd = split[0].split("\\.");
            int Year = Integer.parseInt(ymd[0]);
            int Month = Integer.parseInt(ymd[1]);
            int Day = Integer.parseInt(ymd[2]);
            int term = map.get(split[1]);
            
            totalDays[i] = Day + (28 * (Month-1)) + ((Year-1)*12*28);

            if(totalTodayDays >= term + totalDays[i]) {
                list.add(i);
            }

           
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = list.get(i) + 1;
        }
        return answer;
    }
}