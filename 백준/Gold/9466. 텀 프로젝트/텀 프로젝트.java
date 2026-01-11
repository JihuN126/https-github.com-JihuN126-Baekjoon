import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T,n,Count;
    static ArrayList<Integer>[] List;
    static boolean[] Visited, Checked;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List = new ArrayList[n+1];
            Visited = new boolean[n+1];
            Checked = new boolean[n+1];
            for(int j=1;j<=n;j++) {
                List[j] = new ArrayList<>();
                List[j].add(Integer.parseInt(st.nextToken()));
            }
            Count=0;
            for(int k=1;k<=n;k++) {
                if(!Visited[k]) DFS(k);
            }
            sb.append(n-Count + "\n");
        }
        System.out.println(sb);
    }
    public static void DFS(int Start) {
        Visited[Start] = true;
        int Next = List[Start].get(0);
        if(!Visited[Next]) {
            DFS(Next);
        }
        if(!Checked[Next]) {
            Count++;
            while(Next != Start) {
                Count++;
                Next = List[Next].get(0);
            }
        }
        Checked[Start] = true;
    }
}
