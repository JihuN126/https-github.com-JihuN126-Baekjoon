import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,k;
    static Integer[] score;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        score = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score, Collections.reverseOrder());
        System.out.println(score[k-1]);
    }
}
