import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int index = 1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<skill.length();i++) {
            map.put(skill.charAt(i), index++);
        }
        for(int i=0;i<skill_trees.length;i++) {
            int p = 1;
            for(int j=0;j<skill_trees[i].length();j++) {
                char c = skill_trees[i].charAt(j);
                int result = map.getOrDefault(c, -1);
                if(result==p) {
                    p++;
                }
                else if(result!=-1) {
                    p=-1;
                    break;
                }
            }
            if(p!=-1) answer++;
        }
        return answer;
    }
}