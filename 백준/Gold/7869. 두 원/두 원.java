import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double x1,y1,r1,x2,y2,r2,D,A,B,Area=0;
    static double theta1, theta2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Double.parseDouble(st.nextToken());
        y1 = Double.parseDouble(st.nextToken());
        r1 = Double.parseDouble(st.nextToken());
        x2 = Double.parseDouble(st.nextToken());
        y2 = Double.parseDouble(st.nextToken());
        r2 = Double.parseDouble(st.nextToken());
        D = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
        if(Math.abs(r1-r2) >= D) System.out.printf("%.3f", Math.pow(Math.min(r1,r2),2)*Math.PI);
        else if(r1+r2>D) {
            theta1 = Math.acos((Math.pow(D,2) + Math.pow(r1,2) - Math.pow(r2,2)) / (2*r1*D));
            theta2 = Math.acos((Math.pow(D,2) + Math.pow(r2,2) - Math.pow(r1,2)) / (2*r2*D));
            A = Math.pow(r1,2) * theta1 - (Math.pow(r1,2) * Math.sin(2*theta1) / 2);
            B = Math.pow(r2,2) * theta2 - (Math.pow(r2,2) * Math.sin(2*theta2) / 2);
            Area = A+B;
            System.out.printf("%.3f",Area);
        }
        else System.out.printf("%.3f" , Area);
    }
}
