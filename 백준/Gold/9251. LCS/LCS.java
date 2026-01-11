import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int Arr[][];
    static char s1Arr[],s2Arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();

        Arr = new int[s1.length()+1][s2.length()+1];
        s1Arr = new char[s1.length()];
        s2Arr = new char[s2.length()];

        for(int i=0;i<s1.length();i++) {
            s1Arr[i] = s1.charAt(i);
            Arr[i][0] = 0;
        }
        for(int i=0;i<s2.length();i++) {
            s2Arr[i] = s2.charAt(i);
            Arr[0][i] = 0;
        }

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                if(s1Arr[i-1] == s2Arr[j-1]) Arr[i][j] = Arr[i-1][j-1]+1;
                else Arr[i][j] = Math.max(Arr[i-1][j] , Arr[i][j-1]);
            }
        }
        
        System.out.println(Arr[s1.length()][s2.length()]);
    }
}