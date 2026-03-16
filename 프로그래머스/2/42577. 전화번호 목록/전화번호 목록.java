import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<phone_book.length;i++) {
            map.put(phone_book[i], 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            // System.out.println(key);
            for(int i=1;i<key.length();i++) {
                String str = key.substring(0,i);
                if(map.containsKey(str)) {
                    return false;
                }
            }
        }
        return answer;
    }
}