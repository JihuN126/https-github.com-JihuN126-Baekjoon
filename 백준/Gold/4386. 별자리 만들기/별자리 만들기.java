import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static double x,y,AccumulatedSum=0;
    private static class Star{
        int Number;
        double X,Y;
        public Star(int Number, double X, double Y) {
            this.Number=Number;
            this.X=X;
            this.Y=Y;
        }
    }
    private static class Node implements Comparable<Node>{
        int End;
        double Dist;
        public Node(int end, double dist) {
            End = end;
            Dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            if(this.Dist < o.Dist) return -1;
            if(this.Dist > o.Dist) return 1;
            return 0;
        }
    }
    static ArrayList<Node>[] NodeList;
    static ArrayList<Star> StarList = new ArrayList<>();
    static boolean[] Visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        NodeList = new ArrayList[n+1];
        Visited = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            NodeList[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            StarList.add(new Star(i,x,y));
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==j) continue;
                double dist = Math.sqrt(Math.pow(StarList.get(i-1).X - StarList.get(j-1).X,2) + Math.pow(StarList.get(i-1).Y - StarList.get(j-1).Y,2));
                NodeList[i].add(new Node(j, dist));
            }
        }
        Prim(1);
        System.out.printf("%.2f", AccumulatedSum);
    }
    public static void Prim(int Start) {
        PriorityQueue<Node> Que = new PriorityQueue<>();
        Que.add(new Node(Start,0));
        while(!Que.isEmpty()){
            Node node = Que.poll();
            if(Visited[node.End]) continue;
            Visited[node.End] = true;
            AccumulatedSum += node.Dist;
            for(Node temp : NodeList[node.End]) {
                if(!Visited[temp.End]){
                    Que.add(temp);
                }
            }
        }
    }
}
