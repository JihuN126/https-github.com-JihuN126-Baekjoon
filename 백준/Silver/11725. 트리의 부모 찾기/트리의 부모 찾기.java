import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] Parent;
    static boolean[] Visited;
    static ArrayList<Integer>[] list;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Parent = new int[N+1];
        Visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int Start = Integer.parseInt(st.nextToken());
            int End = Integer.parseInt(st.nextToken());
            list[Start].add(End);
            list[End].add(Start);
        }
        DFS(1);
        for(int i=2;i<N+1;i++) {
            System.out.println(Parent[i]);
        }
    }
    public static void DFS(int K) {
        Visited[K] = true;
        for(int i : list[K]) {
            if(!Visited[i]) {
                Parent[i] = K;
                DFS(i);
            }
        }
    }
}
