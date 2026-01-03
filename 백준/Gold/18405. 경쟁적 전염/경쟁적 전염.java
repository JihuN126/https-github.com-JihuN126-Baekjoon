import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,S,T=0,preVir=-1;
    static int[][] Arr;
    static boolean[][] Flag;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static class Node implements Comparable<Node>{
        int x,y,vir;
        public Node(int x, int y,int vir) {
            this.x = x;
            this.y = y;
            this.vir = vir;
        }
        @Override
        public int compareTo(Node o) {
            return this.vir - o.vir;
        }
    }
    static ArrayList<Node> Vir = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arr = new int[N][N];
        Flag = new boolean[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Arr[i][j] = Integer.parseInt(st.nextToken());
                if(Arr[i][j]!=0) Vir.add(new Node(i,j,Arr[i][j]));
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        Collections.sort(Vir);
        BFS(Vir);
        System.out.println(Arr[X-1][Y-1]);
    }

    public static void BFS(ArrayList<Node> vir) {
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<vir.size();i++) {
            q.add(vir.get(i));
        }
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.vir<preVir) {
                T++;
            }
            if(T==S) return;
            for(int i=0;i<4;i++) {
                int X = cur.x + dx[i];
                int Y = cur.y + dy[i];
                if(X<0 || Y<0 || X>=N || Y>=N) continue;
                if(Arr[X][Y]==0) {
                    Arr[X][Y]=cur.vir;
                    q.add(new Node(X,Y,cur.vir));
                    preVir=cur.vir;
                }

            }
        }

    }

}
