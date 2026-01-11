import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Min=Integer.MAX_VALUE, INF=1000*1000+1;
    static int[][] Arr, DP;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N][3];
        DP = new int[N][3];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) Arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) DP[0][j] = (i!=j ? INF : Arr[0][i]);
            for(int j=1;j<N;j++){
                DP[j][0] = Math.min(DP[j-1][1], DP[j-1][2]) + Arr[j][0];
                DP[j][1] = Math.min(DP[j-1][0], DP[j-1][2]) + Arr[j][1];
                DP[j][2] = Math.min(DP[j-1][0], DP[j-1][1]) + Arr[j][2];
            }
            for(int j=0;j<3;j++) Min=Math.min(Min, DP[N-1][j]);
        }
        System.out.println(Min);
    }
}
