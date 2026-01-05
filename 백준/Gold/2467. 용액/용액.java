import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] solution = new long[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        long minSum = Long.MAX_VALUE;
        long ansLeft = 0;
        long ansRight = 0;

        while (left < right) {
            long sum = solution[left] + solution[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ansLeft = solution[left];
                ansRight = solution[right];
            }

            if (sum == 0) {
                break;
            } else if (sum > 0) {
                right--; 
            } else {
                left++; 
            }
        }

        System.out.println(ansLeft + " " + ansRight);
    }
}