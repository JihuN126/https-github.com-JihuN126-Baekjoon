import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K,T,Answer;
    static int[] Dp, Time, Arr;
    static ArrayList<Integer>[] Edge;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            Time=new int[N+1];
            Dp = new int[N+1];
            Edge = new ArrayList[N+1];
            Arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                Edge[i]= new ArrayList<Integer>();
                Time[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                Edge[X].add(Y);
                Arr[Y]++;
            }
            Answer=Integer.parseInt(br.readLine());
            Queue<Integer> Que = new ArrayDeque<Integer>();
            for(int i=1; i<=N; i++) {
                if(Arr[i]==0) {
                    Que.add(i);
                    Dp[i]=Time[i];
                }
            }
            while(!Que.isEmpty()) {
                int cur = Que.poll();
                for(int i=0; i<Edge[cur].size(); i++) {
                    int next=Edge[cur].get(i);
                    Dp[next]=Math.max(Dp[next], Dp[cur]+Time[next]);
                    Arr[next]--;
                    if(Arr[next]==0) Que.add(next);
                }
            }
            System.out.println(Dp[Answer]);
        }
    }
}