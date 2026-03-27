import java.util.*;
class Solution {
    
    class Carpet {
        int width, height;
        public Carpet(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
    
    public int[] solution(int brown, int yellow) {
        int number = 3; // 최소 세로 길이
        int[] answer = new int[2];
        Queue<Carpet> que = new LinkedList<>();
        while(true) {
            int R = brown - number*2;
            int Width = R / 2 + 2;
            if(number > Width) break;
            // System.out.println(Width + " " + number);
            que.add(new Carpet(Width,number));
            number++;
        }
        Func(que, yellow, answer);
        return answer;
    }
    public void Func(Queue<Carpet> que, int yellow, int[] answer) {
        int size = que.size();
        for(int i=0;i<size;i++) {
            Carpet c = que.poll();
            if((c.width-2)*(c.height-2)==yellow){
                
                answer[0] = c.width;
                answer[1] = c.height;
                return;
            }
        }
        // return;
    }
}