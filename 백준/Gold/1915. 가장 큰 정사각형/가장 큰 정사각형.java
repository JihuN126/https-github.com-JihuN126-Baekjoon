import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[][] square = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<m;j++) {
                square[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                if(square[i][j]==1) answer=1;
            }
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(square[i][j] == 1) {
                    square[i][j] = Math.min(square[i-1][j], Math.min(square[i][j-1], square[i-1][j-1])) + 1;
                    answer = Math.max(answer, square[i][j]);
                }
            }
        }

        System.out.println(answer * answer);
    }
}
