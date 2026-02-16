import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];
        Map<String, Integer> scoreMap = new HashMap<String,Integer>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++) {
            int total=0;
            for(int j=0;j<photo[i].length;j++) {
                String person = photo[i][j];
                if (scoreMap.containsKey(person)) {
                    total += scoreMap.get(person);
                }
            }
            answer[i] = total;
        }
        return answer;
        
    }
}