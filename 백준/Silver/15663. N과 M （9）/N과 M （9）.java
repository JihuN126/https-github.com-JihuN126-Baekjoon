import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] Arr= new int[8];
    static int[] NumList;
    static boolean[] Check = new boolean[8];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        NumList = new int[N];
        for(int i=0;i<N;i++)  NumList[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(NumList);
        DFS(0);
        System.out.println(sb);
    }
    public static void DFS(int index){
        if(index==M){
            for(int i=0;i<index;i++) sb.append(Arr[i]+" ");
            sb.append("\n");
            return;
        }
        int LastNum=0;
        for(int i=0;i<N;i++){
            if(Check[i] || LastNum == NumList[i]) continue;
            LastNum = NumList[i];
            Check[i] = true;
            Arr[index] = NumList[i];
            DFS(index + 1);
            Check[i] = false;
        }
    }
}