import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; // 왼쪽 카드
        int[] B = new int[N]; // 오른쪽 카드
        int[][] D = new int[N + 1][N + 1];

        // 왼쪽 더미 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        // 오른쪽 더미 입력
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) B[i] = Integer.parseInt(st.nextToken());

        // 2차원 DP 진행 (역순 탐색)
        for (int i=N-1;i>=0;i--) {
            for (int j=N-1;j>=0;j--) {
                // 1. 점수를 얻지 못하는 두 가지 경우 중 최댓값 (왼쪽 버리기, 양쪽 버리기)
                D[i][j] = Math.max(D[i + 1][j], D[i + 1][j + 1]);

                // 2. 오른쪽 카드가 더 작아서 점수를 얻을 수 있는 경우
                if (A[i] > B[j]) {
                    D[i][j] = Math.max(D[i][j], D[i][j + 1] + B[j]);
                }
            }
        }

        System.out.println(D[0][0]);
    }
}