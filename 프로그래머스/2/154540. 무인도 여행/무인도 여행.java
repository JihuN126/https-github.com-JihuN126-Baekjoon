import java.util.*;
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    int[] dy = {0,1,0,-1};
    int[] dx = {1,0,-1,0};
    
    class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    Queue<Node> que = new LinkedList<>();
    boolean[][] visited;
    public int[] solution(String[] maps) {
        
        int[][] map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[i].length();j++) {
                char c = maps[i].charAt(j);
                if(c=='X') map[i][j] = 0;
                else {
                    map[i][j] = (int)(c-'0');
                }
            }
        }
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[i].length;j++) {
                if(!visited[i][j] && map[i][j]!=0) {
                    BFS(i,j,map);
                }
            }
        }
        if(result.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    public void BFS(int y, int x, int[][] map) {
        que.add(new Node(y,x));
        visited[y][x] = true;
        int Sum=0;
        while(!que.isEmpty()) {
            
            Node tmp = que.poll();
            System.out.println(tmp.y + " " + tmp.x);
            Sum += map[tmp.y][tmp.x];
            for(int i=0;i<4;i++) {
                int Y = tmp.y + dy[i];
                int X = tmp.x + dx[i];
                if(Y<0 || X<0 || Y >= map.length || X>=map[y].length) continue;
                if(!visited[Y][X] && map[Y][X] != 0) {
                    que.add(new Node(Y,X));
                    visited[Y][X] = true;
                }
            }
        }
        result.add(Sum);
    }
}