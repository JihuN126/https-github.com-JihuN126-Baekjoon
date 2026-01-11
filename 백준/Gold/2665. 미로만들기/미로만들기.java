import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[][] Miro, Distance;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Miro = new int[n][n];
        Distance = new int[n][n];
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            Arrays.fill(Distance[i], Integer.MAX_VALUE);
            for(int j=0;j<n;j++) {
                Miro[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(BFS(0,0));
    }
    public static int BFS(int y,int x) {
        Queue<Node> Que = new LinkedList<>();
        Que.add(new Node(y,x));
        Distance[y][x] = 0;
        while(!Que.isEmpty()) {
            Node temp = Que.poll();
            for(int i=0;i<4;i++) {
                int Dy = temp.y + dy[i];
                int Dx = temp.x + dx[i];
                if(Dy < 0 || Dx < 0 || Dy >= n || Dx >= n) continue;
                if(Distance[Dy][Dx] > Distance[temp.y][temp.x]) {
                    if(Miro[Dy][Dx] == 1) {
                        Distance[Dy][Dx] = Distance[temp.y][temp.x];
                        Que.add(new Node(Dy,Dx));
                    }
                    else {
                        Distance[Dy][Dx] = Distance[temp.y][temp.x] + 1;
                        Que.add(new Node(Dy,Dx));
                    }
                }
            }
        }
        return Distance[n-1][n-1];
    }
}
