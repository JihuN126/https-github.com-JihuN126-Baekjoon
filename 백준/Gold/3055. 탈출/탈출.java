import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] board;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};
    static boolean[][] visited;
    static int answer;

    static class Node {
        int y,x,count;
        public Node(int y, int x, int count) {
            this.y=y;
            this.x=x;
            this.count=count;
        }
    }
    static ArrayList<int[]> waterPosition = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j]=='*') {
                    waterPosition.add(new int[]{i,j});
                }
            }
        }

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(board[i][j]=='S') {
                    BFS(i,j,0);
                }
            }
        }
        System.out.println(answer == 0 ? "KAKTUS" : answer);
    }

    public static void BFS(int y, int x, int count) {
        Queue<Node> routeQue = new LinkedList<>();
        Queue<Node> waterQue = new LinkedList<>();
        routeQue.add(new Node(y,x,0));
        visited[y][x] = true;
        for(int i=0;i<waterPosition.size();i++) {
            waterQue.add(new Node(waterPosition.get(i)[0], waterPosition.get(i)[1],0));
        }
        while(!routeQue.isEmpty()) {

            int size = waterQue.size();

            for(int i=0;i<size;i++) {
                Node waterPosition = waterQue.poll();
                for(int j=0;j<4;j++) {
                    int waterY = waterPosition.y + dy[j];
                    int waterX = waterPosition.x + dx[j];
                    if(waterY>=0 && waterX>=0 && waterY<R && waterX<C && board[waterY][waterX]=='.') {
                        waterQue.add(new Node(waterY,waterX,0));
                        board[waterY][waterX]='*';
                    }
                }
            }

            int routeSize = routeQue.size();
            for (int i=0;i<routeSize;i++) {
                Node curS = routeQue.poll();

                for (int j=0;j<4;j++) {
                    int ny = curS.y + dy[j];
                    int nx = curS.x + dx[j];

                    if (ny>=0 && nx>=0 && ny<R && nx<C) {
                        if (board[ny][nx] == 'D') {
                            answer = curS.count + 1;
                            return;
                        }
                        if (board[ny][nx] == '.' && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            routeQue.add(new Node(ny, nx, curS.count + 1));
                        }
                    }
                }
            }
        }

    }
}