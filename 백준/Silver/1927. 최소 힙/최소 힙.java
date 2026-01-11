import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int K = Integer.parseInt(br.readLine());
            if(K==0 && pq.isEmpty()) System.out.println("0");
            else if(K==0) System.out.println(pq.poll());
            if(K!=0) pq.offer(K);
        }
    }
}