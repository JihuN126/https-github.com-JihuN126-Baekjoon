import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] Workbook;
    static int[] Degree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Workbook = new ArrayList[N+1];
        Degree = new int[N+1];
        for(int i=0;i<=N;i++) Workbook[i] = new ArrayList<>();
        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Degree[B]++;
            Workbook[A].add(B);
        }
        TopologicalSort();
    }
    public static void TopologicalSort() {
        PriorityQueue<Integer> Que = new PriorityQueue<>();
        for(int i=1;i<=N;i++) {
            if(Degree[i]==0) Que.add(i);
        }
        while(!Que.isEmpty()) {
            int temp = Que.poll();
            System.out.print(temp + " ");
            for(int i=0;i<Workbook[temp].size();i++) {
                int n = Workbook[temp].get(i);
                Degree[n]--;
                if(Degree[n]==0) Que.add(n);
            }
        }
    }
}
