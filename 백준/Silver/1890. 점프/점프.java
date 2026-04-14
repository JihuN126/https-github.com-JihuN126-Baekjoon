import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int jump = arr[i][j];
                if(i==N-1 && j==N-1) break;
                if(j+jump < N && dp[i][j]>0) {
                    dp[i][j+jump]+=dp[i][j];
                }
                if(i+jump < N && dp[i][j]>0) {
                    dp[i+jump][j]+=dp[i][j];
                }

            }
        }
//        for(int i=0;i<N;i++) {
//            for(int j=0;j<N;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[N-1][N-1]);
    }
}