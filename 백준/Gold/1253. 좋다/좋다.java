import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++) {
            int p1=0, p2=N-1;
            int target = arr[i];
            while(p1<p2) {
                if(arr[p1] + arr[p2] > target) {
                    p2--;
                }
                else if(arr[p1] + arr[p2] < target) {
                    p1++;
                }
                else if(arr[p1] + arr[p2] == target) {
                    if(p1!=i && p2!=i) {
                        answer++;
                        break;
                    }
                    else if(p1==i) {
                        p1++;
                    }
                    else if(p2==i) {
                        p2--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
