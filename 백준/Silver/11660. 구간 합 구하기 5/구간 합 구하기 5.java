import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] NumArr, AccumulatedSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        NumArr = new int[N+2][N+2];
        AccumulatedSum = new int[N+2][N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                NumArr[i][j] = Integer.parseInt(st.nextToken());
                AccumulatedSum[i][j] = AccumulatedSum[i-1][j] + AccumulatedSum[i][j-1] - AccumulatedSum[i-1][j-1] + NumArr[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(AccumulatedSum[x2][y2] - AccumulatedSum[x2][y1-1] - AccumulatedSum[x1-1][y2] + AccumulatedSum[x1-1][y1-1]);
        }
    }
}