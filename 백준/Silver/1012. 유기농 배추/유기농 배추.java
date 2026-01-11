import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Farm;
    static boolean[][] Visit;
    static int M,N,K;
    static int Count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            Farm = new int[N][M];
            Visit = new boolean[N][M];
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                Farm[B][A] = 1;
            }
            for(int p=0;p<N;p++){
                for(int q=0;q<M;q++){
                    if(!Visit[p][q] && Farm[p][q] == 1){
                        DFS(p,q);
                        Count++;
                    }
                }
            }
            System.out.println(Count);
            Count = 0;
        }
    }
    public static void DFS(int x,int y){
        Visit[x][y] = true;
        if(x>0 && !Visit[x-1][y] && Farm[x-1][y]==1) DFS(x-1,y);
        if(x+1<N && !Visit[x+1][y] && Farm[x+1][y]==1) DFS(x+1,y);
        if(y>0 && !Visit[x][y-1] && Farm[x][y-1]==1) DFS(x,y-1);
        if(y+1<M && !Visit[x][y+1] && Farm[x][y+1]==1) DFS(x,y+1);
    }
}