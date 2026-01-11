import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> RooftopHeight = new Stack<>();
        long Count = 0;
        for(int i=0;i<N;i++){
            int K = Integer.parseInt(br.readLine());
            while(!RooftopHeight.isEmpty()&& RooftopHeight.peek() <= K ) RooftopHeight.pop();
            RooftopHeight.push(K);
            Count += RooftopHeight.size()-1;
        }
        System.out.println(Count);
    }
}