class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int bH = board.length;
        int bW = board[0].length;
        int n = skill.length;
        int[][] diffArray = new int[bH+1][bW+1];
        
        // 구현 자체는 쉬운데 효율성이 문제네?
        // for 문 줄여서 처리할 방법 생각해봐라 이거지?
        // 근데 무슨 방법이 있지...?
        for(int i = 0; i<n; i++){
            int w1 = skill[i][1];
            int h1 = skill[i][2];
            int w2 = skill[i][3];
            int h2 = skill[i][4];
            int degree = skill[i][5];
            
            if(skill[i][0] == 1){
                diffArray[w1][h1] -= degree;
                diffArray[w1][h2 + 1] += degree;
                diffArray[w2 + 1][h1] += degree;
                diffArray[w2 + 1][h2 + 1] -= degree; 
            } else {
                diffArray[w1][h1] += degree;
                diffArray[w1][h2 + 1] -= degree;
                diffArray[w2 + 1][h1] -= degree;
                diffArray[w2 + 1][h2 + 1] += degree; 
            }
        }        
        
        int sum = 0;
        // 가로 방향 누적합
        for(int i = 0; i<bH; i++){
            for(int j = 1; j<bW; j++){
                diffArray[i][j] += diffArray[i][j-1];
            }
        }
        // 세로 방향 누적 합 
        for(int j = 0; j<bW; j++){
            for(int i = 1; i<bH; i++){
                diffArray[i][j] += diffArray[i-1][j];
            }
        }
        
        for(int i = 0; i<bH; i++){
            for(int j = 0; j<bW; j++){
                if(board[i][j] + diffArray[i][j] >0 ) answer++;
            }
        }
        
        
        return answer;
    }
}