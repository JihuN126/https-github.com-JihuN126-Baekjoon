import java.util.*;
class Solution {
    int count = 0;
    Set<String> visitedSet = new HashSet<>();
    public int solution(String dirs) {
        int[] start = {0,0};
        BFS(start, dirs);
        return count;
    }
    public void BFS(int[] start, String dirs) {
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        for(int i=0;i<dirs.length();i++) {
            char c = dirs.charAt(i);
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            
            String root = "";
            root += x + ",";
            root += y + ",";
            if(c=='U') {
                if(y==5) {
                    que.add(new int[]{x,y});
                    continue;
                }
                y += 1;
            }
            else if(c=='D'){
                if(y==-5) {
                    que.add(new int[]{x,y});
                    continue;
                }
                y += (-1);
            }
            else if(c=='R'){
                if(x==5) {
                    que.add(new int[]{x,y});
                    continue;
                }
                x += 1;
            }
            else if(c=='L'){
                if(x==-5) {
                    que.add(new int[]{x,y});
                    continue;
                }
                x += (-1);
            }
            
            root += x + ",";
            root += y;
            String[] reverse = root.split(",");
            String reverseRoot = reverse[2] + "," + reverse[3] + "," +reverse[0] + "," + reverse[1];
            if(!visitedSet.contains(root) && !visitedSet.contains(reverseRoot)) {
                visitedSet.add(root);
                count++;
            }
            
            System.out.println(root + " " + reverseRoot);
            que.add(new int[]{x,y});
        }
    }
}