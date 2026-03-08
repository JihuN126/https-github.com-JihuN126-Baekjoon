import java.util.*;
class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    boolean[][] visited;
    class Node {
        public int y;
        public int x;
        public int length;
        public Node(int y, int x, int length) {
            this.y = y;
            this.x = x;
            this.length = length;
        }
    }
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        int answer = BFS(maps,new Node(0,0,1));
        return answer;
    }
    
    public int BFS(int[][] maps, Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[0][0] = true;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            for(int i=0;i<4;i++) {
                int Dy = cur.y + dy[i];
                int Dx = cur.x + dx[i];
                int length = cur.length;
                if(Dy<0 || Dx<0 || Dy >= maps.length || Dx >= maps[0].length) continue;
                if(Dy == maps.length-1 && Dx == maps[0].length-1) {
                    return length+1;
                }
                if(maps[Dy][Dx] == 1 && !visited[Dy][Dx]) {
                    
                    que.add(new Node(Dy,Dx,length+1));
                    visited[Dy][Dx] = true;
                }
                
            }
        }
        return -1;
    }
}