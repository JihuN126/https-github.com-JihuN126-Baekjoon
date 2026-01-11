
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int [][] Map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Map = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) Map[i][j] = Integer.parseInt(st.nextToken()) + Map[i-1][j] + Map[i][j-1] - Map[i-1][j-1];
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; ++i){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int Result = Map[x2][y2] - Map[x2][y1-1] - Map[x1-1][y2] + Map[x1-1][y1-1];
            sb.append(Result+"\n");
        }
        System.out.println(sb);
    }
}