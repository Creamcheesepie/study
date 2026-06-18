class Solution {
    public int solution(int n) {
        return dfs(n,new boolean[n],new boolean[n*2], new boolean[n*2],0);
    }
    
    private int dfs(int n, boolean[] cols,boolean[] diag1, boolean[] diag2 , int row){
        if(n == row){
            return 1;
        }
        
        int res = 0;
        for(int col = 0; col<n; col++){
            if(!cols[col] && !diag1[row+col] && !diag2[row -col + n]){
                // 퀸 배치
                cols[col] = diag1[row + col] = diag2[row -col + n] = true;
                // 다음 행 이동
                res += dfs(n,cols,diag1,diag2,row +1);
                // 백트래킹
                cols[col] = diag1[row + col] = diag2[row -col + n] = false;
            }
        }
        
        return res;
    }
}