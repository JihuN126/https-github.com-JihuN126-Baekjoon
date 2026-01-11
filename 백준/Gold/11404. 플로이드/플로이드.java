import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,Start,End,Cost;
    static final int INF = 210000000;
    static int Arr[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Arr = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) Arr[i][j] = (i==j ? 0 : INF);
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Start = Integer.parseInt(st.nextToken());
            End = Integer.parseInt(st.nextToken());
            Cost = Integer.parseInt(st.nextToken());
            Arr[Start-1][End-1] = Math.min(Arr[Start-1][End-1], Cost);
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++) Arr[i][j] = Math.min(Arr[i][j], Arr[i][k] + Arr[k][j]);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) Arr[i][j] = (Arr[i][j] == INF ? 0 : Arr[i][j]);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)  System.out.print(Arr[i][j] + " ");
            System.out.println();
        }
    }
}
