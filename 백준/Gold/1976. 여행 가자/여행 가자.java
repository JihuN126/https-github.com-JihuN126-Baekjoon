import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                int connect = Integer.parseInt(st.nextToken());
                if(connect == 1) {
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        int root = find(firstCity);

        boolean possible = true;
        for(int i=1;i<M;i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if(find(nextCity)!=root) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    public static int find(int a) {
        if(a==parent[a]) return a;
        else {
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if(A!=B) {
            parent[A] = B;
        }
    }
}
