import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static Queue<Integer> Que = new LinkedList<>();
    static ArrayList<Integer> Arr = new ArrayList<>();
    static int[] NumCheck = new int[100001];
    static int[] NumList = new int[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BFS(N,K);
        if(K==0 && N==0) System.out.println(0);
        if(K!=0) {
            while (K != 0) {
                Arr.add(K);
                K = NumList[K];
            }
        }
        else{
            while(N!=K){
                Arr.add(K);
                K = NumList[K];
            }
            if(N!=0) System.out.print(N +" ");
        }
        for(int i=0;i<Arr.size();i++){
            if(i==0 && N==0) System.out.print(0+" ");
            System.out.print(Arr.get(Arr.size()-1-i) + " ");
        }
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
                NumList[QueNum*2] = QueNum;
            }
            if(QueNum-1>-1 && NumCheck[QueNum-1]==0){
                Que.offer(QueNum-1);
                NumCheck[QueNum-1] = NumCheck[QueNum] + 1;
                NumList[QueNum-1] = QueNum;
            }
            if(QueNum+1<100001 && NumCheck[QueNum+1]==0){
                Que.offer(QueNum+1);
                NumCheck[QueNum+1] = NumCheck[QueNum] + 1;
                NumList[QueNum+1] = QueNum;
            }
        }
    }
}
