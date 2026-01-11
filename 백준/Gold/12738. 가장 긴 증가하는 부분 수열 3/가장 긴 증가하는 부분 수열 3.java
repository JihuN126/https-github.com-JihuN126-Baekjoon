import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] Arr;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] DP = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  DP[i] = Integer.parseInt(st.nextToken());
        Arr = new int[n+1];
        Arr[0] = -1000000001;
        int len=0;
        int index;
        for(int i=0; i<n; i++) {
            if(DP[i] > Arr[len]) {
                len++;
                Arr[len] = DP[i];
            }else {
                index = BinarySearch(0,len, DP[i]);
                Arr[index] = DP[i];
            }
        }
        System.out.println(len);
    }
    static int BinarySearch(int Left, int Right, int Key) {
        int Mid;
        while(Left<Right) {
            Mid = (Left+Right)/2;
            if(Arr[Mid] < Key) Left = Mid+1;
            else Right = Mid;
        }
        return Right;
    }
}