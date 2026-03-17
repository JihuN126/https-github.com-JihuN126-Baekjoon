import java.util.*;
import java.lang.Math;
class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        int length = String.valueOf(storey).length();
        answer = function(length, storey);
        return answer;
    }
    public int function(int length, int target) {
        int count = 0;
        for(int i=0;i<=length;i++) {
            int num = target % (int)Math.pow(10, 1);
            if(num==0) target/=10;
            else if(num<5) {
                count+=num;
                System.out.println("<5" + " " + target+ " " + count);
                target /= 10;
                
            }
            else if(num>5){
                count+=(10-num);
                System.out.println(">5" + " " + target + " " + count);
                target = target / 10 + 1;
                
            }
            else if (num == 5) {
                if ((target / 10) % 10 >= 5) {
                    count += (10 - num);
                    target = (target / 10) + 1;
                } else {
                    count += num;
                    target /= 10;
                }
            }
            
            
        }
        return count;
    }
}