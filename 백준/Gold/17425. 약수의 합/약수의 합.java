import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int Max=1000001;
        long[] F = new long[Max];
        long[] G = new long[Max];
        Arrays.fill(F,1);
        G[1]=1;
        for (int i = 2; i < Max; i++) {
            for (int j = 1; i * j < Max; j++) F[i * j] += i;
            G[i] = G[i - 1] + F[i];
        }
        for(int i=0;i<T;i++)  sb.append(G[Integer.parseInt(br.readLine())]+"\n");
        System.out.println(sb);
    }
}