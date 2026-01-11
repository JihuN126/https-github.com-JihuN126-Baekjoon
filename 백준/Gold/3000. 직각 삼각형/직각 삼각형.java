import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] Points = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Points[i][0] = Integer.parseInt(st.nextToken());
            Points[i][1] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> xCount = new HashMap<>();
        HashMap<Integer, Integer> yCount = new HashMap<>();

        for(int i = 0; i < N; i++) {
            Integer countX = xCount.get(Points[i][0]);
            Integer countY = yCount.get(Points[i][1]);

            if(countX == null)
                xCount.put(Points[i][0], 1);
            else
                xCount.put(Points[i][0], countX + 1);

            if(countY == null)
                yCount.put(Points[i][1], 1);
            else
                yCount.put(Points[i][1], countY + 1);
        }
        long result = 0;
        for(int i = 0; i < N; i++) {
            long xValue = xCount.get(Points[i][0]) - 1;
            long yValue = yCount.get(Points[i][1]) - 1;
            result += xValue * yValue;
        }
        System.out.println(result);
    }
}
