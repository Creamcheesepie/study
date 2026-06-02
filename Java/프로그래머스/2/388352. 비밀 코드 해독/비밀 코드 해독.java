import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        /*
            1번째 단계에서 가능한 조합 -> 2번째에서 가능한 조합
            해당 조합들에서 겹치지 않고 1~n까지의 개수를 만들어낼 수 있는 수의 조합 합?
            완전탐색? 백트래킹
        */
        return dfs(1, 0, new int[5], q,ans,n);
    }
    
    private int dfs(int start,int idx, int[] comb, int[][] q, int[] ans, int n){
        if(idx == 5){
            if(isCorrect(comb,q,ans)) return 1;
            else return 0;
        }
        int res = 0;
        for(int i = start; i<=n; i++){
            comb[idx] = i;
            res += dfs(i + 1,idx + 1,comb ,q,ans, n);
        }
        return res;
    }
    
    private boolean isCorrect(int[] comb, int[][]q, int[] ans){

        for(int i = 0; i<q.length; i++){
            int[] current = q[i];
            int correct = ans[i];
            
            int cnt = 0;
            for(int no : current){
                for(int cno : comb){
                    if(no == cno) cnt++;
                }
            }
            if(cnt != ans[i]) return false;
        }
        return true;
    }
    
}