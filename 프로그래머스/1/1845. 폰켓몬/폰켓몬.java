import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        int pickSize = length/2;
        
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<length;i++) {
            if(map.getOrDefault(nums[i],0)==0) {
                map.put(nums[i],1);
            }
        }
        int count=1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(count<=pickSize) {
                answer++;
                count++;
            }
        }
        return answer;
    }
}