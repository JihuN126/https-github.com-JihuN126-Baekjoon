class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String answerColor = board[h][w];
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        for(int i=0;i<4;i++) {
            int X = h+dx[i];
            int Y = w+dy[i];
            if(X<0 || Y<0 || X>=board.length || Y>=board.length) continue;
            if(board[X][Y].equals(answerColor)) answer++;
        }
        
        return answer;
    }
}