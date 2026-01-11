import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int y,x;
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static int n,m;
    static int[][] Picture;
    static boolean[][] Check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int Max = 0, Cnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Picture = new int[n][m];
        Check = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) Picture[i][j]= Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(Picture[i][j]==1 && !Check[i][j]){
                    BFS(i,j);
                    Cnt++;
                }
            }
        }
        System.out.println(Cnt);
        System.out.println(Max);
    }
    public static void BFS(int y,int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        Check[y][x] = true;
        int Pnt=0;
        while(!q.isEmpty()){
            Pnt++;
            Node temp = q.poll();
            Check[temp.y][temp.x] = true;
            for(int i=0;i<4;i++){
                int Y = temp.y + dy[i];
                int X = temp.x + dx[i];
                if(X<0 || Y<0 || X>=m || Y>=n) continue;
                if(Picture[Y][X]==1 && !Check[Y][X]){
                    q.add(new Node(Y,X));
                    Check[Y][X] = true;
                }
            }
            Max = Math.max(Max,Pnt);
        }
    }
}