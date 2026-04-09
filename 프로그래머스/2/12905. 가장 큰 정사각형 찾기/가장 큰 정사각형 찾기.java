import java.lang.Math;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] == 1) {
                    if(i*j==0) {
                        answer = Math.max(answer, board[i][j]);
                        continue;
                    }
                    else {
                        board[i][j] = Math.min(board[i-1][j],Math.min(board[i-1][j-1], board[i][j-1])) + 1;
                    }
                    answer = Math.max(answer, board[i][j]);
                }
                
            }
        }
        return answer * answer;
    }
}