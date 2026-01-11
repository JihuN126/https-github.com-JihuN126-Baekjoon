import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,TunnelCount=0;
    static long[][] X,Y,Z;
    static int[] Parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        X = new long[N][2];
        Y = new long[N][2];
        Z = new long[N][2];
        Parent = new int[N];
        for (int i=1;i<N;i++) Parent[i] = i;
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i][0] = i; 
            X[i][1] = Long.parseLong(st.nextToken());
            Y[i][0] = i; 
            Y[i][1] = Long.parseLong(st.nextToken());
            Z[i][0] = i; 
            Z[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(X, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1], o2[1]);
            }
        });
        Arrays.sort(Y, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1], o2[1]);
            }
        });
        Arrays.sort(Z, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1], o2[1]);
            }
        });
        int node = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a[2], b[2]);
        });
        for (int i = 0; i < N - 1; i++) {
            pq.add(new long[] {X[i][0], X[i + 1][0], X[i + 1][1] - X[i][1]});
            pq.add(new long[] {Y[i][0], Y[i + 1][0], Y[i + 1][1] - Y[i][1]});
            pq.add(new long[] {Z[i][0], Z[i + 1][0], Z[i + 1][1] - Z[i][1]});
        }
        while (node < N - 1) {
            long[] current = pq.poll();
            int a = (int) current[0];
            int b = (int) current[1];
            long weight = current[2];
            if (Find_Set(a) != Find_Set(b)) {
                node++;
                Union(a, b);
                TunnelCount += weight;
            }
        }
        System.out.println(TunnelCount);
    }
    public static void Union(int a, int b) {
        int parentA = Find_Set(a);
        int parentB = Find_Set(b);
        if (parentA < parentB) {
            Parent[parentB] = parentA;
        } else if (parentA > parentB) {
            Parent[parentA] = parentB;
        }
    }
    public static int Find_Set(int target) {
        if (target == Parent[target]) return target;
        else return Parent[target] = Find_Set(Parent[target]);
    }
}