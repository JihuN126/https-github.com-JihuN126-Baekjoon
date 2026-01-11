import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m,n,k,sx,sy,dx,dy,Result=0;
    static class Bus {
        int index,x1,y1,x2,y2,type;
        public Bus(int index, int x1, int y1, int x2, int y2, int type) {
            this.index= index;
            this.x1 = Math.min(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.x2 = Math.max(x1, x2);
            this.y2 = Math.max(y1, y2);
            this.type = type;
        }

        public boolean isContain(int x, int y) {
            if (this.type == 0) {
                if (this.x1==x && y>=this.y1 && y<=this.y2)
                    return true;
                else
                    return false;
            } else {
                if (this.y1==y && x>=this.x1 && x<=this.x2)
                    return true;
                else
                    return false;
            }
        }

        public boolean isContain(Bus b) {
            if (this.type==0 && b.type==0) {
                if (this.x1 != b.x1 || this.y1 > b.y2 || this.y2 < b.y1)
                    return false;
                else
                    return true;
            } else if (this.type==1 && b.type==1) {
                if (this.y1 != b.y1 || this.x1 > b.x2 || this.x2 < b.x1)
                    return false;
                else
                    return true;
            } else if (this.type==0 && b.type==1) {
                if (this.x1>=b.x1 && this.x1<=b.x2 && b.y1>=this.y1 && b.y1<=this.y2)
                    return true;
                else
                    return false;
            } else {
                if (this.y1>=b.y1 && this.y1<=b.y2 && b.x1>=this.x1 && b.x1<=this.x2)
                    return true;
                else
                    return false;
            }
        }
    }
    static Bus[] bus;
    static int[] Visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        bus = new Bus[k+1];
        Visited = new int[k+1];
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1==x2) bus[index] = new Bus(index, x1, y1, x2, y2, 0);
            else bus[index] = new Bus(index, x1, y2, x2, y2, 1);
           
        }
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        dx = Integer.parseInt(st.nextToken());
        dy = Integer.parseInt(st.nextToken());
        BFS();
    }

    static void BFS() {
        Queue<Bus> Que = new LinkedList<>();
        for (int i=1; i<=k; i++) {
            if (bus[i].isContain(sx, sy)) {
                Que.add(bus[i]);
                Visited[i] = 1;
            }
        }
        while (!Que.isEmpty()) {
            Bus temp = Que.poll();
            if (temp.isContain(dx, dy)) {
                Result = Visited[temp.index];
                break;
            }
            for (int i=1; i<=k; i++) {
                if (Visited[i] != 0 || !temp.isContain(bus[i])) continue;
                Que.add(bus[i]);
                Visited[i] = Visited[temp.index] + 1;
            }
        }
        System.out.println(Result);
    }
}