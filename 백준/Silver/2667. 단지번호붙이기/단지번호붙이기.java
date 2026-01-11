import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 단지번호 붙이기 - 2667번
 */

public class Main {
    static String[][] Arr = null;
    static boolean[][] Visit;
    static ArrayList<Integer> HouseCounting = new ArrayList<>();
    static int ComplexCount = 0;
    static int HouseCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arr = new String[N+2][N+2];
        Visit = new boolean[N+2][N+2];
        for (int i=1; i< Arr.length-1; i++) {
            String S = br.readLine();
            for (int j=1; j<Arr[i].length-1; j++) {
                Arr[i][j] = "0";
                Arr[i][j] = S.substring(j-1, j);
            }
        }
        for(int i=1; i<Arr.length-1; i++){
            for(int j=1; j<Arr[i].length-1; j++){
                if(!Arr[i][j].equals("0") && !Visit[i][j]) {
                    DFS(i, j);
                    HouseCounting.add(HouseCount);
                }
                HouseCount=0;
            }
        }
        System.out.println(ComplexCount);
        Collections.sort(HouseCounting);
        for(int i=0; i<HouseCounting.size(); i++) System.out.println(HouseCounting.get(i));
    }
        public static void DFS(int x, int y){
            if(Arr[x][y].equals("0") || Arr[x][y] == null || Visit[x][y] == true) return;
            if(HouseCount==0) ComplexCount++;
            HouseCount++;
            Visit[x][y] = true;
            if(Arr[x-1][y]!=null) DFS(x-1,y);
            if(Arr[x+1][y]!=null) DFS(x+1,y);
            if(Arr[x][y-1]!=null) DFS(x,y-1);
            if(Arr[x][y+1]!=null) DFS(x,y+1);
        }
    }