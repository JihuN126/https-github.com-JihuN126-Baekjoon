import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[] Visited;
    static int[] Arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Visited = new boolean[N];
        Arr = new int[N];
        BackTracking(0);
    }

    private static void BackTracking(int length) {
        if(length==M) {
            Print();
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++) {
            if(!Visited[i]) {
                Arr[length] = i;
                Visited[i] = true;
                BackTracking(length+1);
                Visited[i] = false;
            }
        }
    }
    private static void Print() {
        for(int i=0;i<M;i++) {
            System.out.print(Arr[i] + 1 + " ");
        }
    }
}
