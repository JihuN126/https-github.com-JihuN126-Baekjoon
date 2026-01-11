import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
   int x,y,Count;
   public Node(int x, int y,int count) {
      this.x = x;
      this.y = y;
      this.Count = count;
   }
}
public class Main {
   static StringBuilder sb;
   static int N,I;
   static int[] Start = new int[2];
   static int[] End = new int[2];
   static boolean[][] Visit;
   static int[] MoveX = {-1,-2,-2,-1,1,2,2,1};
   static int[] MoveY = {-2,-1,1,2,-2,-1,1,2};
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      sb = new StringBuilder();
      N = Integer.parseInt(br.readLine());
      for(int i=0;i<N;i++){
         I = Integer.parseInt(br.readLine());
         Visit = new boolean[I][I];
         StringTokenizer st = new StringTokenizer(br.readLine());
         Start[0] = Integer.parseInt(st.nextToken());
         Start[1] = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         End[0] = Integer.parseInt(st.nextToken());
         End[1] = Integer.parseInt(st.nextToken());
         BFS(Start[0],Start[1]);
      }
      System.out.println(sb);
   }
   public static void BFS(int x, int y){
      Queue<Node> q = new LinkedList<>();
      q.add(new Node(x,y,0));
      Visit[x][y] = true;
      while(!q.isEmpty()){
         Node temp = q.poll();
         Visit[temp.x][temp.y] = true;
         if(temp.x==End[0] && temp.y==End[1]){
            sb.append(temp.Count+"\n");
            return;
         }
         for(int i=0;i<8;i++){
            int X = temp.x + MoveX[i];
            int Y = temp.y + MoveY[i];
            if(X<0 || Y<0 || X>=I || Y>=I) continue;
            if(!Visit[X][Y]){
               q.add(new Node(X,Y,temp.Count+1));
               Visit[X][Y] = true;
            }
         }
      }
   }
}