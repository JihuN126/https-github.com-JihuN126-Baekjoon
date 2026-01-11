import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] X = new int[3];
        int[] Y = new int[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        int P = (X[0]*Y[1] + X[1]*Y[2] + X[2]*Y[0]) - (X[1]*Y[0] + X[2]*Y[1] + X[0]*Y[2]);
        if(P==0) System.out.println(0);
        else if(P>0) System.out.println(1);
        else System.out.println(-1);
    }
}