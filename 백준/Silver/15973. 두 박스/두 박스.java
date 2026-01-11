import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Ax1 = Integer.parseInt(st.nextToken());
        int Ay1 = Integer.parseInt(st.nextToken());
        int Ax2 = Integer.parseInt(st.nextToken());
        int Ay2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int Bx1 = Integer.parseInt(st.nextToken());
        int By1 = Integer.parseInt(st.nextToken());
        int Bx2 = Integer.parseInt(st.nextToken());
        int By2 = Integer.parseInt(st.nextToken());
        if (Ax2 < Bx1 || Ay1 > By2 || Ay2 < By1 || Ax1 > Bx2)
            System.out.println("NULL");
        else if ((Ay1 == By2 && Ax2 == Bx1) || (Ax2 == Bx1 && Ay2 == By1) || (Ax1 == Bx2 && Ay2 == By1) || (Ax1 == Bx2 && Ay1 == By2))
            System.out.println("POINT");
        else if (((Ay2 - Ay1) + (By2 - By1) == Ay2 - By1) || ((By2 - By1) + (Ay2 - Ay1) == By2 - Ay1))
            System.out.println("LINE");
        else if (((Ax2 - Ax1) + (Bx2 - Bx1) == Ax2 - Bx1) || ((Bx2 - Bx1) + (Ax2 - Ax1) == Bx2 - Ax1))
            System.out.println("LINE");
        else
            System.out.println("FACE");
    }
}