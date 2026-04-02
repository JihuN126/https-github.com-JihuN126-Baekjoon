import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        int[][] MaxArr = new int[N+1][K+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=K;j++){
                if(j-W[i]>=0) {
                    MaxArr[i][j] = Math.max(MaxArr[i-1][j], MaxArr[i-1][j-W[i]] + V[i]);
                }
                else {
                    MaxArr[i][j] = MaxArr[i-1][j];
                }
            }
        }
        System.out.println(MaxArr[N][K]);
    }
}

