import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Node{
    int x,y,cost;
    Node(int x,int y,int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}
public class Main {
    static int Cave[][];
    static int Cost[][];
    static int[] Dx = {-1,0,1,0};
    static int[] Dy = {0,-1,0,1};
    static int N, Count=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            Cave = new int[N][N];
            Cost = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    Cave[i][j] = Integer.parseInt(st.nextToken());
                    Cost[i][j] = Integer.MAX_VALUE;
                }
            }
            Dijkstra();
            sb.append("Problem ").append(++Count).append(": ").append(Cost[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }
    public static void Dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.offer(new Node(0,0,Cave[0][0]));
        Cost[0][0] = Cave[0][0];
        while(!q.isEmpty()){
            Node temp = q.poll();
            int X = temp.x;
            int Y = temp.y;
            for(int i=0;i<4;i++){
                int tempX = X+Dx[i];
                int tempY = Y+Dy[i];
                if(tempX<0 || tempY<0 || tempX>=N || tempY>=N) continue;
                if(Cost[tempX][tempY] > Cost[X][Y] + Cave[tempX][tempY]){
                    Cost[tempX][tempY] = Cost[X][Y] + Cave[tempX][tempY];
                    q.offer(new Node(tempX,tempY,Cost[tempX][tempY]));
                }
            }
        }
    }
}