import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] Arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) Arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(Arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)  sb.append(BinarySearch(Arr,N,Integer.parseInt(st.nextToken()))+" ");
        System.out.println(sb);
    }
    public static int BinarySearch(int[] Arr, int N, int Search) {
        int A = 0;
        int B = N - 1;
        int Mid = 0;
        while (A <= B) {
            Mid = (A + B) / 2;
            if (Arr[Mid] == Search)  return 1;
            if (Arr[Mid] < Search) A = Mid + 1;
            else B = Mid - 1;
        }
        return 0;
    }
}

