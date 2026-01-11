import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int w, h;
    static int[][] Map;
    static boolean[][] Visit;
    static int[] dx = {-1,0,1,0,-1,1,-1,1};
    static int[] dy = {0,-1,0,1,-1,1,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            int Cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0) break;
            Map = new int[h][w];
            Visit = new boolean[h][w];
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) Map[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(Map[i][j]==1 && !Visit[i][j]){
                        Cnt++;
                        BFS(i,j);
                    }
                }
            }
            sb.append(Cnt+"\n");
        }
        System.out.println(sb);
    }
    static public void BFS(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        Visit[x][y] = true;
        while(!q.isEmpty()){
            Node temp = q.poll();
            Visit[temp.x][temp.y] = true;
            for(int i=0;i<8;i++){
                int X = temp.x + dx[i];
                int Y = temp.y + dy[i];
                if(X<0 || Y<0 || X>=h || Y>=w) continue;
                if(Map[X][Y]==1 && !Visit[X][Y]){
                    q.add(new Node(X,Y));
                    Visit[X][Y] = true;
                }
            }
        }
    }
}
