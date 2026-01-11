import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][] Colors;
    static boolean[][] Visit;
    static int Count1 = 0, Count2 = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Colors = new char[N][N];
        Visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            for (int j = 0; j < N; j++) {
                Colors[i][j] = S.charAt(j);
            }
        }
        for(int k=0;k<2;k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((Colors[i][j] == 'R' || Colors[i][j] == 'G' || Colors[i][j] == 'B') && !Visit[i][j] && k==0) {
                        DFS(i, j, Colors[i][j], k);
                        Count1++;
                    }
                    if ((Colors[i][j] == 'R' || Colors[i][j] == 'G' || Colors[i][j] == 'B') && Visit[i][j] && k==1) {
                        DFS(i, j, Colors[i][j], k);
                        Count2++;
                    }
                }
            }
        }
        System.out.println(Count1 + " " +Count2);
    }
    public static void DFS(int x, int y, char s ,int k){
        if(k==0) {
            Visit[x][y] = true;
            if (x - 1 >= 0 && Colors[x - 1][y] == s && !Visit[x - 1][y]) DFS(x - 1, y, s, k);
            if (x + 1 < Colors.length && Colors[x + 1][y] == s && !Visit[x + 1][y]) DFS(x + 1, y, s, k);
            if (y - 1 >= 0 && Colors[x][y - 1] == s && !Visit[x][y - 1]) DFS(x, y - 1, s, k);
            if (y + 1 < Colors.length && Colors[x][y + 1] == s && !Visit[x][y + 1]) DFS(x, y + 1, s, k);
        }
        if(k==1){
            Visit[x][y] = false;
            if(s=='B') {
                if (x - 1 >= 0 && Colors[x - 1][y] == s && Visit[x - 1][y]) DFS(x - 1, y, s, k);
                if (x + 1 < Colors.length && Colors[x + 1][y] == s && Visit[x + 1][y]) DFS(x + 1, y, s, k);
                if (y - 1 >= 0 && Colors[x][y - 1] == s && Visit[x][y - 1]) DFS(x, y - 1, s, k);
                if (y + 1 < Colors.length && Colors[x][y + 1] == s && Visit[x][y + 1]) DFS(x, y + 1, s, k);
            }
            else{
                if (x - 1 >= 0 && (Colors[x - 1][y] == 'G' ||  Colors[x - 1][y] == 'R') && Visit[x - 1][y]) DFS(x - 1, y, s, k);
                if (x + 1 < Colors.length && (Colors[x + 1][y] == 'G' ||  Colors[x + 1][y] == 'R') && Visit[x + 1][y]) DFS(x + 1, y, s, k);
                if (y - 1 >= 0 &&(Colors[x][y - 1] == 'G' ||  Colors[x][y - 1] == 'R') && Visit[x][y - 1]) DFS(x, y - 1, s, k);
                if (y + 1 < Colors.length && (Colors[x][y + 1] == 'G' ||  Colors[x][y + 1] == 'R') && Visit[x][y + 1]) DFS(x, y + 1, s, k);
            }
        }
    }
}