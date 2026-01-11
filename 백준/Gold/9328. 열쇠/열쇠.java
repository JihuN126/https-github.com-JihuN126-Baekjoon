import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int h,w,T,MaxCount;
    static char[][] Map;
    static boolean[][] Visited;
    static boolean[] Key;
    static ArrayList<Node>[] Door;
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0},dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            MaxCount = 0;
            Map = new char[h+2][w+2];
            Door = new ArrayList[26];
            Key = new boolean[26];
            Visited = new boolean[h +2][w +2];
            for(int i=0;i<26;i++) Door[i] = new ArrayList<>();
            for(int i=0;i<h;i++) {
                String[] data = br.readLine().split("");
                for(int j=0;j<w;j++) {
                    Map[i+1][j+1] = data[j].charAt(0);
                }
            }
            for(int i=0;i<h+2;i++) {
                Map[i][0] = '.';
                Map[i][w +1] = '.';
            }

            for(int i=0;i<w+2;i++) {
                Map[0][i] = '.';
                Map[h +1][i] = '.';
            }

            String[] str = br.readLine().split("");
            for(int i=0;i<str.length;i++) {
                if(str[i].charAt(0) == '0') break;
                Key[str[i].charAt(0) - 'a'] = true;
            }
            BFS();
            sb.append(MaxCount +"\n");
        }

        System.out.println(sb);
    }

    public static void BFS() {
        Queue<Node> Que = new LinkedList<>();
        Que.add(new Node(0, 0));
        Visited[0][0] = true;
        while(!Que.isEmpty()) {
            Node node = Que.poll();
            for(int d=0;d<4;d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(nx < 0 || nx >= (h +2) || ny < 0 || ny >= (w+2) || Visited[nx][ny]) continue;
                if(Map[nx][ny] == '*') continue;
                if(Map[nx][ny] - 'A' >= 0 && Map[nx][ny] - 'A' <= 25) {
                    if(Key[Map[nx][ny]-'A']) {
                        Visited[nx][ny] = true;
                        Map[nx][ny] = '.';
                        Que.add(new Node(nx, ny));
                    }
                    else {
                        Door[Map[nx][ny]-'A'].add(new Node(nx, ny));
                    }
                }
                else if(Map[nx][ny] -'a' >= 0 && Map[nx][ny] - 'a' <= 25) {
                    int n = Map[nx][ny]-'a';
                    Key[Map[nx][ny]-'a'] = true;
                    Map[nx][ny] = '.';
                    Visited[nx][ny] = true;
                    Que.add(new Node(nx, ny));
                    for(Node temp : Door[n]) {
                        Visited[temp.x][temp.y] = true;
                        Que.add(new Node(temp.x, temp.y));
                    }
                }
                else if(Map[nx][ny] == '$') {
                    Map[nx][ny] = '.';
                    MaxCount++;
                    Visited[nx][ny] = true;
                    Que.add(new Node(nx, ny));
                }
                else if(Map[nx][ny] == '.'){
                    Visited[nx][ny] = true;
                    Que.add(new Node(nx, ny));
                }
            }
        }
    }
}