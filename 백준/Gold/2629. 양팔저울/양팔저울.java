import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int Ball[];
    public static boolean Checked[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Ball = new int[N+1];
        Checked = new boolean[40001];
        StringTokenizer st=  new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)  Ball[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) {
            var temp = new ArrayList<Integer>();
            temp.add(Ball[i]);
            for(int j=1;j<=15000;j++) {
                if(Checked[j]) {
                    if(Ball[i]-j > 0) temp.add(Ball[i]-j);
                    if(Ball[i]+j <= 15000)  temp.add(Ball[i]+j);                    
                    if(j-Ball[i] > 0) temp.add(j-Ball[i]);
                }
            }
            for(int j=0;j<temp.size();j++) Checked[temp.get(j)] = true;
            
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int q = Integer.parseInt(st.nextToken());
            if(Checked[q]) System.out.println("Y");
            else System.out.println("N");
        }
    }
}