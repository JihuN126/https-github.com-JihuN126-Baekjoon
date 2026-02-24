class Solution {
    //["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
    //["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
    //["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
    public int[] solution(String[] park, String[] routes) {
        int startX=0;
        int startY=0;
        char[][] road = new char[park.length][park[0].length()];
        for(int i=0;i<park.length;i++) {
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j)=='S') {
                    startY = i;
                    startX = j;
                }
                road[i][j] = park[i].charAt(j);
                // System.out.println(park[i].charAt(j));
            }
        }
        int[] answer = Move(startY, startX, routes, road);
        return answer;
    }
    public int[] Move(int y, int x, String[] routes, char[][] road) {
        int posY = y;
        int posX = x;
        for(int i=0;i<routes.length;i++) {
            // System.out.println(i);
            String[] arr = routes[i].split(" ");
            String direction = arr[0];
            int size = Integer.parseInt(arr[1]);
            // System.out.println(direction + " " +size);
            int backupY = posY;
            int backupX = posX;
            boolean isFailed = false;
            for (int j = 1; j <= size; j++) {
                if (direction.equals("E")) posX++;
                else if (direction.equals("W")) posX--;
                else if (direction.equals("S")) posY++;
                else if (direction.equals("N")) posY--;

                if (posY < 0 || posY >= road.length || posX < 0 || posX >= road[0].length || 
                road[posY][posX] == 'X') {
                    isFailed = true;
                    break;
                }
            }
            if(isFailed) {
                posY = backupY;
                posX = backupX;
            }
        }
        int[] answer = {posY, posX};
        return answer;
    }
}