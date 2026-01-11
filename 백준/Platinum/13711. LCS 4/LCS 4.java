import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] LIS, Arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        LIS = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=N; i++) LIS[Integer.parseInt(st.nextToken())] = i;
        Arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) Arr[i] = LIS[Integer.parseInt(st.nextToken())];
        int j = 0;
        LIS[j++] = Arr[0];
        for (int i = 1; i < N; i++) {
            int index = Arrays.binarySearch(LIS, 0, j, Arr[i]);
            if (index == -(j + 1)) LIS[j++] = Arr[i];
            else LIS[-(index + 1)] = Arr[i];
        }
        System.out.println(j);
    }
}