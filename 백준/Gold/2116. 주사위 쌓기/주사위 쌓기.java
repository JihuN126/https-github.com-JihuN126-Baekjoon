import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int dice[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dice=new int[N][6];
        for(int i=0;i<N;i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int Max= 0;
        for(int i=0;i<6;i++) {
            int Sum = Dice(i);
            Max=Math.max(Sum,Max);
        }
        System.out.println(Max);
    }
    public static int Dice(int index) {
        int newDice[] = new int[2];
        newDice[0] = dice[0][index];
        switch(index) {
            case 0: newDice[1] = dice[0][5]; break;
            case 1: newDice[1] = dice[0][3]; break;
            case 2: newDice[1] = dice[0][4]; break;
            case 3: newDice[1] = dice[0][1]; break;
            case 4: newDice[1] = dice[0][2]; break;
            case 5: newDice[1] = dice[0][0]; break;
        }
        int Sum = 0;
        for(int i=0;i<6;i++) {
            if(dice[0][i]==newDice[0]||dice[0][i]==newDice[1]) continue;
            Sum=Math.max(Sum,dice[0][i]);
        }

        for(int i=1;i<dice.length;i++) {
            int Max = 0;
            newDice = dice(i,newDice[0]);
            for(int j=0;j<dice[0].length;j++) {
                if(dice[i][j]==newDice[0]||dice[i][j]==newDice[1]) continue;
                Max=Math.max(Max,dice[i][j]);
            }
            Sum+=Max;
        }
        return Sum;
    }
    public static int [] dice (int index,int Top) {
        int bottom = Top;
        int top = otherSideDice(index,Top);
        return new int[] {top,bottom};
    }

    public static int otherSideDice(int idx,int Top) {
        int index= -1;
        int result = -1;
        for(int i=0;i<6;i++) {
            if(dice[idx][i]==Top)
                index = i;
        }
        switch(index) {
            case 0 : result = dice[idx][5]; break;
            case 1 : result = dice[idx][3]; break;
            case 2 : result = dice[idx][4]; break;
            case 3 : result = dice[idx][1]; break;
            case 4 : result = dice[idx][2]; break;
            case 5 : result = dice[idx][0]; break;
        }
        return result;
    }
}