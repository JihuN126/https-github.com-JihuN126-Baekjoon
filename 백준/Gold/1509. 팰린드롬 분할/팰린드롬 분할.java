import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] Dp;
    static boolean[][] Arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = str.length();
        str = "."+str;
        Arr = new boolean[N+1][N+1];
        Dp = new int[N+1];
        checkPalindrome(str);
        Arrays.fill(Dp, Integer.MAX_VALUE);
        Dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if(Arr[j][i]) Dp[i]=Math.min(Dp[i], Dp[j-1]+1);
            }
        }
        System.out.println(Dp[N]);
    }
    private static void checkPalindrome(String str) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                boolean flag = true;
                int from = j;
                int to = i;
                while(from<=to) {
                    if(str.charAt(from++) != str.charAt(to--)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) Arr[j][i] = true;
            }
        }
    }
}