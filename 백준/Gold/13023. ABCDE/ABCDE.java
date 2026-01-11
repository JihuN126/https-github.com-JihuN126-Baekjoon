import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M,a,b,MaxCount;
    static boolean Answer;
    static List<Integer>[] Graph;
    static boolean[] Visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new List[N];
        for(int i=0;i<N;i++) Graph[i] = new ArrayList<>();
        Visited = new boolean[N];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            Graph[a].add(b);
            Graph[b].add(a);
        }
        for(int i=0;i<N;i++) {
            DFS(i,1);
            if(Answer) break;
            Visited[i]=false;
        }
        System.out.println(Answer ? 1 : 0);
    }
    static void DFS(int S,int Cnt) {
        MaxCount = Math.max(MaxCount,Cnt);
        if(MaxCount == 5) {
            Answer=true;
            return;
        }
        Visited[S]=true;
        for(int T : Graph[S]){
            if(!Visited[T]){
                Visited[T]=true;
                DFS(T,Cnt+1);
                Visited[T]=false;
            }
        }
    }
}
