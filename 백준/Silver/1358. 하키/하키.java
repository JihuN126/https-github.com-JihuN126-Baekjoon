import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int W,H,X,Y,P, Player = 0;
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());
      P = Integer.parseInt(st.nextToken());
      for(int i=0;i<P;i++) {
         st = new StringTokenizer(br.readLine()," ");
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         if(squareCal(x, y) || semicicleCal(x, y))
            Player++;
      }
      System.out.println(Player);
   }
   static boolean squareCal(int x, int y) {
      if(x>=X && y>=Y && x<=X+W && y<=Y+H) return true;
      return false;
   }
   static boolean semicicleCal(int x, int y) {
      int radius = H/2;
      if(x<X) {
         int centerX = X;
         int centerY = Y + radius;
         double distance = Distance(x, y, centerX, centerY);
         if(distance <= radius) return true;
      }else if(x>X+W) {
         int centerX = X + W;
         int centerY = Y + radius;
         double distance = Distance(x, y, centerX, centerY);
         if(distance<=radius) return true;
      }
      return false;
   }
   static double Distance(int x1, int y1, int x2, int y2) {
      double Distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
      return Distance;
   }
}