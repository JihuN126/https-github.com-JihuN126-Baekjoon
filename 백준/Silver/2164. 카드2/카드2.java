import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<=19;i++){
            if(Math.pow(2, i) == N){
                System.out.println(N);
                break;
            }
            else if(N>=Math.pow(2, i-1) && N<Math.pow(2, i)){
                System.out.println((int)(2 * (N % Math.pow(2, i-1))));
                break;
            }
        }
    }
}