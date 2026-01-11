import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] Triangle;
    static int Sum = 0, Max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Triangle = new int[N][];
        StringTokenizer st;
        for(int i=0;i<N;i++)  Triangle[i] = new int[i+1];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<i+1;j++){
                Triangle[i][j] = Integer.parseInt(st.nextToken());
                if(i>0 && j==0)  Triangle[i][j] += Triangle[i-1][j];
                else if(i>0 && i==j) Triangle[i][j] += Triangle[i-1][j-1];
                else if(i!=0 && i!=j) Triangle[i][j] += Math.max(Triangle[i-1][j-1], Triangle[i-1][j]);
                if(Max<Triangle[i][j])  Max = Triangle[i][j];
                }
            }
        System.out.println(Max);
    }
}