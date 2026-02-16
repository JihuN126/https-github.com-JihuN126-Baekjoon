class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int pointer1 = 0;
        int pointer2 = 0;
        for(int i=0;i<goal.length;i++) {
            String str = goal[i];
            if(pointer1<cards1.length && cards1[pointer1].equals(str)) {
                pointer1++;
            }
            else if(pointer2<cards2.length && cards2[pointer2].equals(str)) {
                pointer2++;
            }
            else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}