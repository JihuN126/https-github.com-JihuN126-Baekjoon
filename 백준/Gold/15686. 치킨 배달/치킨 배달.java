import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int[] SelectArray;
    static int Answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        SelectArray = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String str = st.nextToken();
                if (str.equals("1")) home.add(new int[]{i, j});
                else if (str.equals("2")) chicken.add(new int[]{i, j});
            }
        }
        DFS(0, 0);
        System.out.println(Answer);
    }

    private static void DFS(int Count, int Start) {
        if (Count == M) {
            int Dist = 0;
            for (int[] Y : home) {
                int dist = Integer.MAX_VALUE;
                for (int X : SelectArray) {
                    dist = Math.min(Math.abs(Y[0] - chicken.get(X)[0]) + Math.abs(Y[1] - chicken.get(X)[1]), dist);
                }
                Dist += dist;
            }
            Answer = Math.min(Answer, Dist);
            return;
        }
        for (int i = Start; i < chicken.size(); i++) {
            SelectArray[Count] = i;
            DFS(Count + 1, i + 1);
        }
    }
}