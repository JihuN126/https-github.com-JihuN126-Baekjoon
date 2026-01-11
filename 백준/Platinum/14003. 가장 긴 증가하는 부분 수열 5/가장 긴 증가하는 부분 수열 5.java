import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N,len=0,index=0;
    static int[] Arr, DP, LISSIZE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        DP = new int[N+1];
        LISSIZE = new int[N+1];
        DP[0] = -1000000001;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) Arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            if(Arr[i] > DP[len]) {
                len++;
                LISSIZE[i] = len;
                DP[len] = Arr[i];
            }
            else {
                index = BinarySearch(0,len,Arr[i]);
                LISSIZE[i] = index;
                DP[index] = Arr[i];
            }
        }
        System.out.println(len);
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1;i>=0;i--) {
            if(LISSIZE[i]==len) {
                stack.push(Arr[i]);
                len--;
            }
        }
        for(int i=stack.size()-1;i>=0;i--) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static int BinarySearch(int Left, int Right, int Key) {
        int Mid;
        while(Left<Right) {
            Mid = (Left+Right) / 2;
            if(DP[Mid] < Key) Left = Mid+1;
            else Right = Mid;
        }
        return Right;
    }
}