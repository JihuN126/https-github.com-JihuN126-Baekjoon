import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] Arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            Arr[i] = i;
        }
        for(int i=2;i<=Math.sqrt(N);i++) {
            for(int j=i;j<=N;j+=i) {
                if(i==j) continue;
                Arr[j]=0;
            }
        }
        for(int i=M;i<=N;i++) {
           if(Arr[i]!=0 && i!=1) System.out.println(Arr[i]);
        }
    }
}
