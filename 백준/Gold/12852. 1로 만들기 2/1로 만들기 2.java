import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] F = new int[N+1];
        int[] Count = new int[N+1];
        Arrays.fill(Count, Integer.MAX_VALUE);
        Count[1]=0;
        F[1]=1;
        for(int i=1;i<=N;i++) {
            if(i+1<=N && Count[i+1] > Count[i]) {
                Count[i+1] = Count[i] + 1;
                F[i+1] = i;
            }
            if(i*2<=N && Count[i*2] > Count[i]) {
                Count[i*2] = Count[i] + 1;
                F[i*2] = i;
            }
            if(i*3<=N && Count[i*3] > Count[i]) {
                Count[i*3] = Count[i] + 1;
                F[i*3] = i;
            }
        }
        int now = N;
        StringBuilder sb = new StringBuilder();
        sb.append(Count[N] + "\n");
        while(true) {
            sb.append(now + " ");
            if(now==1) break;
            now = F[now];
        }
        System.out.println(sb.toString());
    }
}
