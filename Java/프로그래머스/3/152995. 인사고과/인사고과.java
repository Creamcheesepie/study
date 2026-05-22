import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoTotal = wanho[0] + wanho[1]; 
        
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        int max = 0;
        int rank = 1;
        for(int[] s : scores){
            if(s[1] < max){
              if(s[0] == wanho[0] && s[1] == wanho[1]) return -1;  
            } 
            else {
                max = Math.max(max,s[1]);
                if(s[0] + s[1] > wanhoTotal) rank++;
            }
        }
        
        return rank;
    }
}