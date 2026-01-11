import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] Arr;
    static boolean[][] Visit;
    static int[] AlphabetCheck;
    static int R, C, Count=0, MaxCount=1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Arr = new char[R][C];
        Visit = new boolean[R][C];
        AlphabetCheck = new int[26];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j=0;j<C;j++)  Arr[i][j] = S.charAt(j);
        }
        DFS(0,0);
        System.out.println(MaxCount);
    }
    public static void DFS(int x, int y){
        Visit[x][y] = true;
        AlphabetCheck[Arr[x][y]-'A']++;
        Count++;
        if(x-1>=0 && !Visit[x-1][y] && AlphabetCheck[Arr[x-1][y]-'A']==0){
            DFS(x-1,y);
            Visit[x-1][y]=false;  AlphabetCheck[Arr[x-1][y]-'A']=0;
            if(MaxCount<Count) MaxCount=Count;
            Count--;
        }
        if(x+1<R && !Visit[x+1][y] && AlphabetCheck[Arr[x+1][y]-'A']==0){
            DFS(x+1,y);
            Visit[x+1][y]=false;  AlphabetCheck[Arr[x+1][y]-'A']=0;
            if(MaxCount<Count) MaxCount=Count;
            Count--;
        }
        if(y-1>=0 && !Visit[x][y-1] && AlphabetCheck[Arr[x][y-1]-'A']==0){
            DFS(x,y-1);
            Visit[x][y-1]=false;  AlphabetCheck[Arr[x][y-1]-'A']=0;
            if(MaxCount<Count) MaxCount=Count;
            Count--;
        }
        if(y+1<C && !Visit[x][y+1] && AlphabetCheck[Arr[x][y+1]-'A']==0){
            DFS(x,y+1);
            Visit[x][y+1]=false;  AlphabetCheck[Arr[x][y+1]-'A']=0;
            if(MaxCount<Count) MaxCount=Count;
            Count--;
        }
    }
}