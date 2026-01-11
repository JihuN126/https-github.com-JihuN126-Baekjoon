import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static Queue<Integer> Que = new LinkedList<>();
    static int[] NumCheck;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        NumCheck = new int[100001];
        BFS(N,K);
    }
    public static void BFS(int N, int K){
        Que.offer(N);
        NumCheck[N]++;
        while(!Que.isEmpty()){
            int QueNum = Que.poll();
            if(QueNum==K){
                System.out.println(NumCheck[K]-1);
                break;
            }
            if(QueNum*2<100001 && NumCheck[QueNum*2]==0){
                Que.offer(QueNum*2);
                NumCheck[QueNum*2] = NumCheck[QueNum] + 1;
            }
            if(QueNum-1>=0 && NumCheck[QueNum-1]==0){
                Que.offer(QueNum-1);
                NumCheck[QueNum-1] = NumCheck[QueNum] + 1;
            }
            if(QueNum+1<100001 && NumCheck[QueNum+1]==0){
                Que.offer(QueNum+1);
                NumCheck[QueNum+1] = NumCheck[QueNum] + 1;
            }
        }
    }
}

