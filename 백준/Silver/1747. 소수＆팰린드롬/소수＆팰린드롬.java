import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = N; i < 999999999; i++) {
            if (Prime(i) && Palindrom(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean Palindrom(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        if (!sb.toString().equals(sb.reverse().toString()))
            return false;
        return true;
    }

    private static boolean Prime(int num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}