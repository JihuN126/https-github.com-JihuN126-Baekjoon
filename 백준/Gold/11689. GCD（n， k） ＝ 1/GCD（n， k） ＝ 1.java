import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long k = n;
        for(int i=2; i<= Math.sqrt(n); i++) {
            if(n%i == 0) k = k/i*(i-1);
            while(n%i == 0) n = n/i;
        }
        if(n != 1) k = k/n*(n-1);
        System.out.println(k);
    }
}