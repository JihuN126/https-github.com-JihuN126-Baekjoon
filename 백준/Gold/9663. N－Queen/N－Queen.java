import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] Chess;
    static int Count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Chess = new int[N];
        BackTracking(0);
        System.out.println(Count);
    }

    private static void BackTracking(int index) {
        if(index==N) {
            Count++;
            return;
        }
        for(int i=0;i<N;i++) {
            Chess[index] = i;
            if(Checking(index)){
                BackTracking(index+1);
            }
        }
    }

    private static boolean Checking(int index) {
        for(int i=0;i<index;i++) {
            if(Chess[i]==Chess[index]) return false;
            if(Math.abs(Chess[i]-Chess[index])==Math.abs(i-index)) return false;
        }
        return true;
    }
}
