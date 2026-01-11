import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] Map;
    static int[] Arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map = new long[N];
        Arr = new int[N];

        for(int i=0; i<N; i++) Map[i] = Long.parseLong(st.nextToken());
        F();
        for(int i=0;i<Arr.length;i++)  answer = Math.max(answer, Arr[i]);
        System.out.println(answer);
    }
    public static void F(){

        boolean Cnt;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                Cnt = true;
                for(int k=i+1; k<j; k++){
                    if(Check(i,j,k) <= 0){
                        Cnt = false;
                        break;
                    }
                }
                if(Cnt){
                    Arr[i]++;
                    Arr[j]++;
                }
            }
        }
    }

    static long Check(int a, int b, int c){
        return  (long)a*Map[c] + (long)b*Map[a] + (long)c*Map[b] - ((long)a*Map[b] + (long)b*Map[c] + (long)c*Map[a]);
    }
}
