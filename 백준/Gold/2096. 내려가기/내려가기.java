import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] MaxArr = new int[N][3];
        int[][] MinArr = new int[N][3];
        int Max , Min;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) MaxArr[i][j] = MinArr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++){
            MaxArr[i][0]+=Math.max(MaxArr[i-1][0],MaxArr[i-1][1]);
            MaxArr[i][2]+=Math.max(MaxArr[i-1][1],MaxArr[i-1][2]);
            MaxArr[i][1]+=Math.max(MaxArr[i-1][0],Math.max(MaxArr[i-1][1],MaxArr[i-1][2]));
            }
        for(int i=1;i<N;i++){
            MinArr[i][0]+=Math.min(MinArr[i-1][0],MinArr[i-1][1]);
            MinArr[i][2]+=Math.min(MinArr[i-1][1],MinArr[i-1][2]);
            MinArr[i][1]+=Math.min(MinArr[i-1][0],Math.min(MinArr[i-1][1],MinArr[i-1][2]));
        }
        Max=Math.max(MaxArr[N-1][0],Math.max(MaxArr[N-1][1],MaxArr[N-1][2]));
        Min=Math.min(MinArr[N-1][0],Math.min(MinArr[N-1][1],MinArr[N-1][2]));
       System.out.println(Max+" "+Min);
    }
}