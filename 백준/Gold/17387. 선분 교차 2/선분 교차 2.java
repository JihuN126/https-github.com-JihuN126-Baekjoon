import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());
        long result1 = CCW(x1,y1,x2,y2,x4,y4)*CCW(x1,y1,x2,y2,x3,y3);
        long result2 = CCW(x3,y3,x4,y4,x1,y1)*CCW(x3,y3,x4,y4,x2,y2);

        if(result1 == 0 && result2 == 0) {
            if(Math.min(x1,x2) <= Math.max(x3,x4) && Math.min(x3,x4) <= Math.max(x1,x2)
                    && Math.min(y1,y2) <= Math.max(y3,y4) && Math.min(y3,y4) <= Math.max(y1,y2)) {
                System.out.println(1);
            }
            else System.out.println(0);
        }
        else if(result1<=0 && result2<=0) System.out.println(1);
        else System.out.println(0);
    }
    public static long CCW(long x1,long y1,long x2,long y2, long x3, long y3){
        long Result = (x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3);
        if(Result<0) return 1;
        else if(Result>0) return -1;
        else return 0;
    }
}