import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
    int Start,End,Cost;
    public Edge(int start, int end, int cost) {
        Start = start;
        End = end;
        Cost = cost;
    }
}
public class Main {
    static int V,E,A,B,C,Sum=0;
    static int[] ParentArray;
    static ArrayList<Edge> List = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        ParentArray = new int[V+1];
        for(int i=1;i<ParentArray.length;i++) ParentArray[i] = i;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            List.add(new Edge(A,B,C));
        }

        List.sort(Comparator.comparingInt(Node -> Node.Cost));

        for(int i=0;i<E;i++) {
            Edge node = List.get(i);
            int start = Find_Set(node.Start);
            int end = Find_Set(node.End);
            if(!Comparison(start,end)){
                Sum += node.Cost;
                Union(node.Start, node.End);
            }
        }
        System.out.println(Sum);
    }
    public static int Find_Set(int X){
        return X == ParentArray[X] ? X : Find_Set(ParentArray[X]);
    }
    public static void Union(int X, int Y){
        ParentArray[Find_Set(Y)] = Find_Set(X);
    }
    public static boolean Comparison(int X, int Y){
        return Find_Set(X) == Find_Set(Y) ? true : false;
    }
}
