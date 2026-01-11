import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] Nums = new int[1000001];
    static Queue<Integer> Num = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(BFS(N));
    }
    public static int BFS(int N){
        Num.offer(N);
        while(!Num.isEmpty()) {
            int K = Num.poll();
            if(K==1) break;
            if(K%3==0 && Nums[K/3]==0){
                Nums[K/3]++;
                Num.offer(K/3);
                Nums[K/3] = Nums[K]+1;
            }
            if(K%2==0 && Nums[K/2]==0){
                Nums[K/2]++;
                Num.offer(K/2);
                Nums[K/2] = Nums[K]+1;
            }
            if(Nums[K-1]==0) {
                Nums[K-1]++;
                Num.offer(K-1);
                Nums[K-1] = Nums[K]+1;
            }
        }
        return Nums[1];
    }
}