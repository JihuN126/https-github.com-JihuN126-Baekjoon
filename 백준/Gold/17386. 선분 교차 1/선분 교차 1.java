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
        System.out.println((result1<0 && result2<0) ? 1 : 0);
    }
    public static long CCW(long x1,long y1,long x2,long y2, long x3, long y3){
        return (x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3) < 0 ? 1 : -1;
    }
}