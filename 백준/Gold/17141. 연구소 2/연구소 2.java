import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,MinTime = Integer.MAX_VALUE,index=0,ZeroCount=0;
    static int[][] Map, CopyMap;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static ArrayList<Node> VirusArr = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][N];
        CopyMap = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if(Map[i][j]==2) {
                    Map[i][j]=-1;
                    VirusArr.add(new Node(i,j));
                }
                if(Map[i][j]==1) Map[i][j] = -3;
            }
        }
        Virus(0,0);
        System.out.println(MinTime==Integer.MAX_VALUE ? -1 : MinTime);
    }
    public static void Virus(int Count, int Start) {
        if(Count==M) {
            BFS();
            return;
        }
        for(int i=Start;i<VirusArr.size();i++) {
            Map[VirusArr.get(i).y][VirusArr.get(i).x] = -2;
            Virus(Count+1,i+1);
            Map[VirusArr.get(i).y][VirusArr.get(i).x] = -1;
        }
    }
    public static void BFS() {
        Queue<Node> Que = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                CopyMap[i][j] = Map[i][j];
                if(CopyMap[i][j]==-2) Que.add(new Node(i,j));
            }
        }
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            for(int i=0;i<4;i++) {
                int Dy = temp.y + dy[i];
                int Dx = temp.x + dx[i];
                if(Dy < 0 || Dx < 0 || Dy >= N || Dx >= N) continue;
                if(CopyMap[Dy][Dx]==0 || CopyMap[Dy][Dx]==-1){
                    if(CopyMap[temp.y][temp.x]==-2) CopyMap[Dy][Dx] = 1;
                    else CopyMap[Dy][Dx] = CopyMap[temp.y][temp.x] + 1;
                    Que.add(new Node(Dy,Dx));
                }
            }
        }

        int Time = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(CopyMap[i][j]==0 || CopyMap[i][j]==-1) return;
                if(CopyMap[i][j]>0) Time = Math.max(Time, CopyMap[i][j]);
            }
        }
        MinTime = Math.min(MinTime, Time);
    }
}
