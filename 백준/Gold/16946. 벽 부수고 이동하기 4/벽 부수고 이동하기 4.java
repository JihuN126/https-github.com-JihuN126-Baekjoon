import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N,M;
    static int[][] Map,District;
    static HashMap<Integer, Integer> hashmap = new HashMap<>();
    static int[] dy = {-1, 0, 1, 0},dx = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        District = new int[N][M];
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++) Map[i][j] = str.charAt(j) - 48;
        }
        int Number = 1;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(Map[i][j] == 1 || District[i][j] != 0) continue;
                hashmap.put(Number, BFS(i, j, Number++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(Map[i][j] == 1){
                    HashSet<Integer> hashset = new HashSet<>();
                    int ans = 1;
                    for(int k=0; k < 4; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 0 || ny >= N || nx < 0 || nx >= M || Map[ny][nx] != 0) continue;
                        int d = District[ny][nx];
                        if(!hashset.contains(d)){
                            hashset.add(d);
                            ans += hashmap.get(d);
                        }
                    }
                    sb.append(ans % 10);
                } else sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int BFS(int i, int j, int Number){
        Queue<Integer> Que = new LinkedList<>();
        Que.offer(i * M + j);
        District[i][j] = Number;
        int cnt = 1;
        while(!Que.isEmpty()){
            int num = Que.poll();
            int y = num / M;
            int x = num % M;
            for(int k=0; k < 4; k++){
                int ny = y + dy[k];
                int nx = x + dx[k];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || Map[ny][nx] == 1) continue;
                if(District[ny][nx] == 0){
                    District[ny][nx] = Number;
                    Que.offer(ny * M + nx);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}