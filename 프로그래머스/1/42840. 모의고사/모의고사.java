import java.lang.*;
class Solution {
    class Student {
        int count = 0;
        int[] Arr;
        public Student(int[] Arr) {
            this.Arr = Arr;
        }
    }
    public int[] solution(int[] answers) {
        
        Student[] std = new Student[3];
        int index = 0;
        int MaxScore = 0;
        std[0] = new Student(new int[]{1, 2, 3, 4, 5});
        std[1] = new Student(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        std[2] = new Student(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        int length = answers.length;
        for(int i=0;i<length;i++) {
            for(int j=0;j<3;j++) {
                if(answers[i] == std[j].Arr[i % std[j].Arr.length]) {
                    std[j].count++;
                };
            }
        }
        MaxScore = Math.max(std[0].count, Math.max(std[1].count, std[2].count));
        int winCount = 0;
        for (int i = 0; i < 3; i++) {
            if (std[i].count == MaxScore) {
                winCount++;
            }
        }
        int[] answer = new int[winCount];
        for(int i=0;i<3;i++) {
            if(std[i].count == MaxScore) {
                answer[index++] = i+1;
            }
        }
        return answer;
    }
}