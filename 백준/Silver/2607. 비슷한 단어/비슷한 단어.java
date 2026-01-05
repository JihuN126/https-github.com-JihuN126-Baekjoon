import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        String first = br.readLine();
        int[] originArr = new int[26];
        for (int i = 0; i < first.length(); i++) {
            originArr[first.charAt(i) - 'A']++;
        }

        for (int i = 1; i < n; i++) {
            String compare = br.readLine();
            int[] tempArr = originArr.clone(); 
            int sameCount = 0; 

            for (int j = 0; j < compare.length(); j++) {
                if (tempArr[compare.charAt(j) - 'A'] > 0) {
                    sameCount++;
                    tempArr[compare.charAt(j) - 'A']--; 
                }
            }


            if (first.length() == compare.length() && (first.length() == sameCount || first.length() - 1 == sameCount)) {
                result++;
            }

            else if (first.length() == compare.length() - 1 && compare.length() - 1 == sameCount) {
                result++;
            }

            else if (first.length() == compare.length() + 1 && compare.length() == sameCount) {
                result++;
            }
        }
        System.out.println(result);
    }
}