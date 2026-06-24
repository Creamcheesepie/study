class Solution {
    public int solution(String[] board) {
        int xCnt = 0;
        int oCnt = 0;
        int xWin = 0;
        int oWin = 0;
        
        for(int h = 0; h<3; h++){
            for(int w = 0; w<3; w++){
                char mark = board[h].charAt(w);
                if(mark == 'X') xCnt++;
                else if(mark == 'O') oCnt++;
            }
        }
        
        for(int h = 0; h<3; h++){
            char mark = board[h].charAt(0);
            if(mark != '.'){
                if(mark == board[h].charAt(1) && mark == board[h].charAt(2)){
                    if(mark == 'X') xWin ++;
                    if(mark == 'O') oWin ++;
                }
            }
        }
        
        for(int w = 0; w<3; w++){
            char mark = board[0].charAt(w);
            if(mark != '.'){
                if(mark == board[1].charAt(w) && mark == board[2].charAt(w)) {
                    if(mark == 'X') xWin ++;
                    if(mark == 'O') oWin ++;
                }
            }
        }
        
        if(board[0].charAt(0) != '.' && board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)) {
                    if(board[0].charAt(0) == 'X') xWin ++;
                    if(board[0].charAt(0) == 'O') oWin ++;
                }
        if(board[0].charAt(2) != '.' && board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0)) {
                    if(board[0].charAt(2) == 'X') xWin ++;
                    if(board[0].charAt(2) == 'O') oWin ++;
                }
        
        if(!(xCnt == oCnt || xCnt + 1 == oCnt)) return 0;
        if (oWin > 0 && xWin > 0) return 0; 
        if (oWin > 0 && oCnt != xCnt + 1) return 0;
        if (xWin > 0 && oCnt != xCnt) return 0;
        
        return 1;
    }
}