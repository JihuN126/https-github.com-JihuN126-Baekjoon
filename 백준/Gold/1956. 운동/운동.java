import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V,E,a,b,c,Min = Integer.MAX_VALUE;
    static int[][] Floyd;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Floyd = new int[V][V];
        for(int i=0;i<V;i++) {
            Arrays.fill(Floyd[i], 0);
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            Floyd[a-1][b-1] = c;
        }

        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(Floyd[i][k]==0 || Floyd[k][j]==0 || i==j) continue;
                    if(Floyd[i][j]==0) Floyd[i][j] = Floyd[i][k] + Floyd[k][j];
                    Floyd[i][j] = Math.min(Floyd[i][j], Floyd[i][k] + Floyd[k][j]);
                 }
            }
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(Floyd[i][j] == 0 || Floyd[j][i] == 0) continue;
                Min = Math.min(Floyd[i][j] + Floyd[j][i] , Min);
            }
        }
        Min = Min == Integer.MAX_VALUE ? -1 : Min;
        System.out.println(Min);
    }
}
