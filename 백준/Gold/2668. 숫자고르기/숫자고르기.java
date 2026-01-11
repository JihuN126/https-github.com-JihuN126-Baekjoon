import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int N, Number;
    static int[] Arr;
    static List<Integer> List;
    static boolean[] Checked;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Checked = new boolean[N];
        Arr = new int[N];
        for(int i=0;i<N;i++) Arr[i] = Integer.parseInt(br.readLine())-1;
        List = new LinkedList<Integer>();
        for (int i = 0; i< N; i++) {
            Checked[i] = true;
            Number = i;
            DFS(i);
            Checked[i] = false;
        }
        Collections.sort(List);
        System.out.println(List.size());
        for(Integer x: List) {
            System.out.println(x+1);
        }
    }

    public static void DFS(int i) {
        if(Arr[i]== Number) List.add(Number);
        if(!Checked[Arr[i]]) {
            Checked[Arr[i]] = true;
            DFS(Arr[i]);
            Checked[Arr[i]]=false;
        }
    }
}