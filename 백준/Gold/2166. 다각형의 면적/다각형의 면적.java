import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] X = new long[N+1];
        long[] Y = new long[N+1];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Long.parseLong(st.nextToken());
            Y[i] = Long.parseLong(st.nextToken());
        }
        X[N]=X[0];
        Y[N]=Y[0];
        long A=0,B=0;
        for(int i=0;i<N;i++){
            A+=(X[i]*Y[i+1]);
            B+=(Y[i]*X[i+1]);
        }
        System.out.println(String.format("%.1f",Math.abs(A-B)/2D));
    }
}