class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer=health;
        int index = 0;
        int time=0, attack=0;
        int pastTime=0, pastAttack=0;
        while(answer > 0) {
            
            if(time!=0) {
                time = attacks[index][0];
                attack = attacks[index][1];
                index++;
                System.out.println(pastTime + " " + time);
                int count = time - pastTime - 1;
                int bandages=0;
                if(count/bandage[0] > 0) {
                     // bandages = count * bandage[1] + (count - bandage[0] + 1) * bandage[2];
                    bandages = count * bandage[1] + (count / bandage[0] * bandage[2]);
                }
                else if(count==0) {
                     bandages=0;
                }
                else {
                    bandages = count * bandage[1];
                }
                
                System.out.println("bandages : " + bandages);
                answer += bandages;
                if(answer > health) answer = health;
                System.out.println("answer : " + answer);
                
                answer -= attack;
                pastTime = time;
                System.out.println("answer : " + answer);
                if(index>attacks.length-1) break;
            }
            else {
                time = attacks[index][0];
                attack = attacks[index][1];
                index++;

                answer -= attack;
                pastTime = time;
                System.out.println("answer : " + answer);
            }
            
        }
        return answer > 0 ? answer : -1;
    }
}