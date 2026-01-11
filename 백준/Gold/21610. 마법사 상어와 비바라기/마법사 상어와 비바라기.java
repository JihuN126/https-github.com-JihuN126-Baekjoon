import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static ArrayList<Node> Cloud;
    public static int[][] Map;
    public static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1},dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][N];
        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j< N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Cloud = new ArrayList<>();
        Cloud.add(new Node(N -1, 0));
        Cloud.add(new Node(N -1, 1));
        Cloud.add(new Node(N -2, 0));
        Cloud.add(new Node(N -2, 1));
        for(int k = 0; k< M; k++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            boolean[][] Checked = new boolean[N][N];
            for(Node node: Cloud) {
                int nx = node.x + dx[K] * (S% N);
                int ny = node.y + dy[K] * (S% N);
                if(nx < 0) {
                    nx = N - Math.abs(nx);
                } else if(nx >= N) {
                    nx -= N;
                }
                if(ny < 0) {
                    ny = N - Math.abs(ny);
                } else if(ny >= N) {
                    ny -= N;
                }
                Map[nx][ny] += 1;
                Checked[nx][ny] = true;
                node.x = nx;
                node.y = ny;
            }
            int[][] MapCopy = new int[N][N];
            for(Node node: Cloud) {
                int Cnt = 0;
                for(int d=2;d<=8;d+=2) {
                    int nx = node.x + dx[d];
                    int ny = node.y + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    if(Map[nx][ny] > 0 ) {
                        Cnt++;
                    }
                }
                MapCopy[node.x][node.y] = Cnt;
            }
            for(int i = 0; i< N; i++) {
                for(int j = 0; j< N; j++) {
                    Map[i][j] += MapCopy[i][j];
                }
            }
            Cloud.clear();
            for(int i = 0; i< N; i++) {
                for(int j = 0; j< N; j++) {
                    if(Map[i][j] >= 2 && !Checked[i][j]) {
                        Cloud.add(new Node(i, j));
                        Map[i][j] -= 2;
                    }
                }
            }
        }
        int Ans = 0;
        for(int i = 0; i< N; i++) {
            for(int j = 0; j< N; j++) {
                Ans += Map[i][j];
            }
        }
        System.out.println(Ans);
    }
}