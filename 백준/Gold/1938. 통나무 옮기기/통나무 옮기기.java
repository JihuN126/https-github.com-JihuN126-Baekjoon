import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char Map[][];
    static int N;
    static int[] dx = {-1,-1,-1,1,1,1,0,0},dy = {-1,0,1,-1,0,1,-1,1};
    static boolean Visited[][][];
    static Queue<Node> Que = new LinkedList<>();
    static class Node{
        int x,y,shape,cnt;
        Node(int x, int y, int shape, int cnt){
            this.x=x;
            this.y=y;
            this.shape=shape;
            this.cnt=cnt;
        }
    }
    static Node Finish = new Node(0,0,0,0);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Map = new char[N][N];
        Visited = new boolean[N][N][2];
        for(int i = 0; i< N; i++) {
            String str = br.readLine();
            for(int j = 0; j< N; j++) {
                Map[i][j]=str.charAt(j);
            }
        }
        boolean Check= true;
        for(int i = 0; i< N; i++) {
            if(!Check) break;
            for(int j = 0; j< N; j++) {
                if(Map[i][j]=='B') {
                    if(i+1< N && Map[i+1][j]=='B') {
                        Que.add(new Node(i+1,j,0,0));
                        Check = false;
                        break;
                    }
                    else if(j+1< N && Map[i][j+1]=='B') {
                        Que.add(new Node(i,j+1,1,0));
                        Check = false;
                        break;
                    }
                }
            }
        }
        Check=true;
        for(int i = 0; i< N; i++) {
            if(!Check) break;
            for(int j = 0; j< N; j++) {
                if(Map[i][j]=='E') {
                    if(i+1< N && Map[i+1][j]=='E') {
                        Finish.x=i+1;
                        Finish.y=j;
                        Finish.shape=0;
                        Check = false;
                        break;
                    }
                    else if(j+1< N && Map[i][j+1]=='E') {
                        Finish.x=i;
                        Finish.y=j+1;
                        Finish.shape=1;
                        Check = false;
                        break;
                    }
                }
            }
        }
        BFS();
    }
    public static void BFS() {
        while(!Que.isEmpty()) {
            Node a = Que.poll();
            int x=a.x;
            int y=a.y;
            int Count=0;
            int shape =a.shape;
            if(a.x== Finish.x && a.y== Finish.y && a.shape == Finish.shape) {
                System.out.println(a.cnt);
                return;
            }
            for(int i=0; i<8; i++) {
                int dx = x+ Main.dx[i];
                int dy = y+ Main.dy[i];
                if(dx>=0 && dy>=0 && dx< N && dy< N && Map[dx][dy]!='1') Count++;
            }
            if(Count==8) {
                if(shape==0) {
                    if(!Visited[x][y][1]) {
                        Que.add(new Node(x,y,1,a.cnt+1));
                        Visited[x][y][1]=true;
                    }
                }
                else {
                    if(!Visited[x][y][0]) {
                        Que.add(new Node(x,y,0,a.cnt+1));
                        Visited[x][y][0]=true;
                    }
                }
            }

            
            if(shape ==0) {
                if(x-2>=0 && !Visited[x-1][y][shape] && Map[x-2][y]!='1') { 
                    Que.add(new Node(x-1,y,shape,a.cnt+1));
                    Visited[x-1][y][shape]=true;
                }
                if(x+2< N && !Visited[x+1][y][shape] && Map[x+2][y]!='1') {  
                    Que.add(new Node(x+1,y,shape,a.cnt+1));
                    Visited[x+1][y][shape]=true;
                }
                if(y-1>=0 && !Visited[x][y-1][shape] && Map[x-1][y-1]!='1' && Map[x][y-1]!='1' && Map[x+1][y-1]!='1') { //L
                    Que.add(new Node(x,y-1,shape,a.cnt+1));
                    Visited[x][y-1][shape]=true;
                }
                if(y+1< N && !Visited[x][y+1][shape] && Map[x-1][y+1]!='1' && Map[x][y+1]!='1' && Map[x+1][y+1]!='1') { //L
                    Que.add(new Node(x,y+1,shape,a.cnt+1));
                    Visited[x][y+1][shape]=true;
                }
            }
            else {
                if(x-1>=0 && !Visited[x-1][y][shape] && Map[x-1][y]!='1' && Map[x-1][y+1]!='1' && Map[x-1][y-1]!='1') { //U
                    Que.add(new Node(x-1,y,shape,a.cnt+1));
                    Visited[x-1][y][shape]=true;
                }
                if(x+1< N && !Visited[x+1][y][shape] && Map[x+1][y]!='1' && Map[x+1][y+1]!='1' && Map[x+1][y-1]!='1') {  //D
                    Que.add(new Node(x+1,y,shape,a.cnt+1));
                    Visited[x+1][y][shape]=true;
                }
                if(y-2>=0 && !Visited[x][y-1][shape] && Map[x][y-2]!='1') { 
                    Que.add(new Node(x,y-1,shape,a.cnt+1));
                    Visited[x][y-1][shape]=true;
                }
                if(y+2< N && !Visited[x][y+1][shape] && Map[x][y+2]!='1') {
                    Que.add(new Node(x,y+1,shape,a.cnt+1));
                    Visited[x][y+1][shape]=true;
                }
            }
        }
        System.out.println(0);
    }
}
