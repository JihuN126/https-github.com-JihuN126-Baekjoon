import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,x,y,index;
    static double MinDist = Double.MAX_VALUE;
    static class Node{
        double x,y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Node[] Arr = new Node[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Arr[i] = new Node(x,y);
        }
        for(int i=0;i<N;i++) {
            double MaxDist = 0;
            for(int j=0;j<N;j++) {
                if(i==j) continue;
                double Dist = Math.sqrt(Math.pow(Arr[i].x - Arr[j].x, 2) + Math.pow(Arr[i].y - Arr[j].y, 2));
                MaxDist = Math.max(Dist, MaxDist);
            }
            if(MinDist > MaxDist) {
                MinDist = MaxDist;
                index = i;
            }
        }
        System.out.printf("%.12f", Arr[index].x);
        System.out.print(" ");
        System.out.printf("%.12f", Arr[index].y);
    }
}
