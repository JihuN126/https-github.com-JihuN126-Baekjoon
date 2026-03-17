import java.lang.Math;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        char[][] position = new char[4][3];
        int Ly=3,Lx=0,Ry=3,Rx=2;
        int My=0, Mx=0;
        for(int i : numbers) {            
            if(i%3==1) {
                sb.append("L");
                position[Ly][Lx] = ' ';
                position[i/3][0] = 'L';
                Ly = i/3;
                Lx = 0;
            }
            else if(i!=0 && i%3==0) {
                sb.append("R");
                position[Ry][Rx] = ' ';
                position[(i/3)-1][2] = 'R';
                Ry = (i/3)-1;
                Rx = 2;
            }
            else {
                if(i==0) {
                    My=3;
                    Mx=1;
                }
                else {
                    My=i/3;
                    Mx=1;
                }
                
                int distanceLeft = Math.abs(My-Ly) + Math.abs(Mx-Lx);
                int distanceRight = Math.abs(My-Ry) + Math.abs(Mx-Rx);
                // System.out.println(distanceLeft + " " + distanceRight);
                System.out.println(My + " " + Ly);
                System.out.println(Mx + " " + Lx);
                System.out.println(My + " " + Ry);
                System.out.println(Mx + " " + Rx + "\n");
                if(distanceLeft > distanceRight) {
                    position[Ry][Rx] = ' ';
                    position[My][Mx] = 'R';
                    Ry = My;
                    Rx = Mx;
                    sb.append("R");
                }
                else if(distanceLeft < distanceRight) {
                    position[Ly][Lx] = ' ';
                    position[My][Mx] = 'L';
                    Ly = My;
                    Lx = Mx;
                    sb.append("L");
                }
                else {
                    if(hand.equals("right")) {
                        position[Ry][Rx] = ' ';
                        position[My][Mx] = 'R';
                        Ry = My;
                        Rx = Mx;
                        sb.append("R");
                    }
                    else {
                        position[Ly][Lx] = ' ';
                        position[My][Mx] = 'L';
                        Ly = My;
                        Lx = Mx;
                        sb.append("L");
                    }
                }
            }
        }
        return sb.toString();
    }
}