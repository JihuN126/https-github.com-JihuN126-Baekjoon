import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] degree;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for(int j=1;j<size;j++) {
                int curr = Integer.parseInt(st.nextToken());
                list[prev].add(curr);
                degree[curr]++;
                prev=curr;
            }
        }
        Func();

    }
    public static void Func() {
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            if(degree[i]==0) {
                que.add(i);
            }
        }
        if(que.isEmpty()) {
            System.out.println(0);
            return;
        }
        while(!que.isEmpty()) {
            int temp = que.poll();
            result.add(temp);

            for(int i=0;i<list[temp].size();i++) {
                degree[list[temp].get(i)]--;
                if(degree[list[temp].get(i)]==0) que.add(list[temp].get(i));
            }
        }
        
        if (result.size() != N) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int node : result) {
                sb.append(node).append("\n");
            }
            System.out.print(sb);
        }
    }

}
