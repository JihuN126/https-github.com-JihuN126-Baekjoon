import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, s;
    static int[][] Arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arr = new int[n+1][n+1];
        for(int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Arr[start][end] = -1;
            Arr[end][start] = 1;
        }
        Floyd();
        s = Integer.parseInt(br.readLine());
        for(int i=0;i<s;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(Arr[start][end] + "\n");
        }
        System.out.println(sb);
    }

    public static void Floyd() {
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(Arr[i][j] == 0) {
                        if(Arr[i][k] == 1 && Arr[k][j] == 1) Arr[i][j] = 1;
                        else if(Arr[i][k] == -1 && Arr[k][j] == -1) Arr[i][j] = -1;
                    }
                }
            }
        }
    }
}