import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static String s1,s2,s3;
    static char[] s1Arr, s2Arr, s3Arr;
    static int[][][] Arr;
    static ArrayList<Character> Arrlist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        s3 = br.readLine();
        Arr = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        s1Arr = new char[s1.length()];
        s2Arr = new char[s2.length()];
        s3Arr = new char[s3.length()];
        Arrlist = new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            s1Arr[i] = s1.charAt(i);
            Arr[i][0][0] = 0;
        }
        for(int i=0;i<s2.length();i++){
            s2Arr[i] = s2.charAt(i);
            Arr[0][i][0] = 0;
        }
        for(int i=0;i<s3.length();i++){
            s3Arr[i] = s3.charAt(i);
            Arr[0][0][i] = 0;
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                for(int k=1;k<=s3.length();k++){
                    if(s1Arr[i-1] == s2Arr[j-1] && s2Arr[j-1] == s3Arr[k-1]) Arr[i][j][k] = Arr[i-1][j-1][k-1] + 1;
                    else Arr[i][j][k] = Math.max(Arr[i-1][j][k],Math.max(Arr[i][j-1][k] , Arr[i][j][k-1]));
                }
            }
        }
        System.out.println(Arr[s1.length()][s2.length()][s3.length()]);
    }
}
