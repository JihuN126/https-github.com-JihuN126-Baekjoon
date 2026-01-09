import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tC = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tM = new TreeMap<>();
        int k, num;
        while(tC-- > 0) {
            k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch(st.nextToken()){
                    case "I":
                        num = Integer.parseInt(st.nextToken());
                        tM.put(num, tM.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if(!tM.isEmpty()) {
                            num = Integer.parseInt(st.nextToken());
                            if (num == -1) num = tM.firstKey();
                            else num = tM.lastKey();
                            if (tM.put(num, tM.get(num) - 1) == 1) tM.remove(num);
                        }
                        break;
                }
            }
            System.out.println(!tM.isEmpty() ? tM.lastKey() + " " + tM.firstKey() : "EMPTY");
            tM.clear();
        }
    }
}