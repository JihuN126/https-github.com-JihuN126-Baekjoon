import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());
        while(true){
            if(T.charAt(T.length()-1)=='A') T.deleteCharAt(T.length()-1);
            else if(T.charAt(T.length()-1)=='B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
            if(T.toString().equals(S.toString())){
                System.out.println(1);
                break;
            }
            else if(T.length() == S.length()){
                System.out.println(0);
                break;
            }
        }
    }
}