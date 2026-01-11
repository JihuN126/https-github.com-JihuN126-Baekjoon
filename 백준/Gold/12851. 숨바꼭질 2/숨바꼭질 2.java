import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Visit[];
    static int N,K,Min,Count=0;
    static Queue<Integer> Num = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Visit = new int[100001];
        if(N==K){
            System.out.println("0");
            System.out.println("1");
        }
        else {
            BFS(N);
            System.out.println(Min);
            System.out.println(Count);
        }
    }
    public static void BFS(int N){
        Num.offer(N);
        while(!Num.isEmpty()){
            int A = Num.poll();
            if(K==A){
                Min = Visit[A];
                Count++;
            }
            if(A-1>=0 && (Visit[A-1]==0 || Visit[A-1] == Visit[A] + 1)){
                Num.offer(A-1);
                Visit[A-1] = Visit[A] + 1;
            }
            if(A+1<=100000 && (Visit[A+1]==0 || Visit[A+1] == Visit[A] + 1)){
                Num.offer(A+1);
                Visit[A+1] = Visit[A] + 1;
            }

            if(A*2<=100000 && (Visit[A*2]==0 || Visit[A*2] == Visit[A] + 1)){
                Num.offer(A*2);
                Visit[A*2] = Visit[A] + 1;
            }
        }
    }
}