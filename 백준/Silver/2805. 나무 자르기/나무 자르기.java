import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] Tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            Tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Tree);
        int result = BinarySearch(Tree,M);
        System.out.println(result);
    }

    public static int BinarySearch(int[] Tree, int M) {
        int left = 0;
        int right = Tree[Tree.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < Tree.length; i++) {
                if (Tree[i] > mid) {
                    sum += (Tree[i] - mid);
                }
            }

            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
