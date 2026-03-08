import java.util.*;
class Solution {
    public boolean[] visited = new boolean[1000001];
    class Node {
        int x,y,n,count;
        public Node(int x,int y,int n,int count) {
            this.x = x;
            this.y=y;
            this.n=n;
            this.count=count;
        }
    }
    public int solution(int x, int y, int n) {
        int answer = BFS(new Node(x,y,n,0));
        visited[x] = true;
        return answer;
    }
    public int BFS(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        Node tmp=null;
        while(!que.isEmpty()) {
            tmp = que.poll();
            if(tmp.x > tmp.y || visited[tmp.x]) {
                continue;
            }
            if(tmp.x == tmp.y) {
                return tmp.count;
            }
            visited[tmp.x] = true;
            que.add(new Node(tmp.x+tmp.n,tmp.y,tmp.n,tmp.count+1));
            que.add(new Node(tmp.x*2,tmp.y,tmp.n,tmp.count+1));
            que.add(new Node(tmp.x*3,tmp.y,tmp.n,tmp.count+1));
        }
        return -1;
    }
}