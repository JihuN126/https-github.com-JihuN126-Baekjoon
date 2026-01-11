import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,Count=0;
    static ArrayList<Integer>[] Arrlist;
    static boolean[] Visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Visited = new boolean[N];
        Arrlist = new ArrayList[N];
        for(int i=0;i<N;i++) Arrlist[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Arrlist[u-1].add(v-1);
            Arrlist[v-1].add(u-1);
        }
        for(int i=0;i<N;i++) {
            if(!Visited[i]) {
                BFS(i);
                Count++;
            }
        }
        System.out.println(Count);
    }
    public static void BFS(int Start){
        Queue<Integer> Que = new LinkedList<>();
        Visited[Start] = true;
        Que.add(Start);
        while(!Que.isEmpty()) {
            int temp = Que.poll();
            for(int i=0;i<Arrlist[temp].size();i++) {
                if(!Visited[Arrlist[temp].get(i)]) {
                    Que.add(Arrlist[temp].get(i));
                    Visited[Arrlist[temp].get(i)] = true;
                }
            }
        }
    }
}
