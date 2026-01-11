import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Size=0, Max=0;
    static class Line {
        long x1, y1, x2, y2;
        public Line(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static int[] Parent,Cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Line[] line = new Line[N+1];
        Parent = new int[N+1];
        Cnt = new int[N+1];
        for (int i=1;i<=N;i++) Parent[i] = i;
        long x1, y1, x2, y2;
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Long.parseLong(st.nextToken());
            y1 = Long.parseLong(st.nextToken());
            x2 = Long.parseLong(st.nextToken());
            y2 = Long.parseLong(st.nextToken());
            line[i] = new Line(x1, y1, x2, y2);
        }
        int ParentA, ParentB;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (i == j) continue;
                ParentA = Find(i);
                ParentB = Find(j);
                if (ParentA != ParentB) {
                    if (CrossCheckMethod(line[i], line[j])) Union(i, j);
                }
            }
        }
        for (int i=1;i<=N;i++) Cnt[Parent[i]]++;
        for (int i=1;i<=N;i++) {
            if (Max < Cnt[i]) Max = Cnt[i];
            if (Cnt[i] != 0) Size++;
        }
        System.out.println(Size);
        System.out.println(Max);
    }

    public static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (result == 0) return 0;
        return result > 0 ? 1 : -1;
    }
    public static int Find(int x) {
        if (x == Parent[x]) return x;
        return Parent[x] = Find(Parent[x]);
    }
    public static void Union(int x, int y) {
        if (Find(x) != Find(y)) Parent[Find(x)] = Find(y);
    }
    public static boolean CrossCheckMethod(Line l1, Line l2) {
        long check1 = CCW(l1.x1, l1.y1, l1.x2, l1.y2, l2.x1, l2.y1) * CCW(l1.x1, l1.y1, l1.x2, l1.y2, l2.x2, l2.y2);
        long check2 = CCW(l2.x1, l2.y1, l2.x2, l2.y2, l1.x1, l1.y1) * CCW(l2.x1, l2.y1, l2.x2, l2.y2, l1.x2, l1.y2);
        if (check1 == 0 && check2 == 0) return OverLappedCheckMethod(l1, l2);
        return check1 <= 0 && check2 <= 0;
    }

    public static boolean OverLappedCheckMethod(Line l1, Line l2) {
        if (Math.max(l1.x1, l1.x2) < Math.min(l2.x1, l2.x2)) return false;
        if (Math.max(l2.x1, l2.x2) < Math.min(l1.x1, l1.x2)) return false;
        if (Math.max(l1.y1, l1.y2) < Math.min(l2.y1, l2.y2)) return false;
        if (Math.max(l2.y1, l2.y2) < Math.min(l1.y1, l1.y2)) return false;
        return true;
    }
}
