import java.util.*;

class Solution {
    
    String answer = "";
    // DFS 사용?
    // 사전순으로 빠르게니까 dir을 사전우선순으로 순환시키면 되는거 아닌가?
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(new int[]{x,y},new int[] {r,c},new int[] {n,m} ,k, 0, new StringBuilder());
        if(answer.isEmpty()) return "impossible";
        return answer;
    }
    
    int[] dirX = new int[] {1, 0, 0, -1};
    int[] dirY = new int[] {0, -1, 1, 0};
    char[] dirChar = new char[] {'d', 'l','r','u'};
    
    private void dfs(int[] pos ,int[] target, int[] range, int k, int dist, StringBuilder sb){
        int x = pos[0];
        int y = pos[1];
        
        int remainDist = k - dist;
        int manhattan = Math.abs(x - target[0]) + Math.abs(y - target[1]);

        if (manhattan > remainDist || (remainDist - manhattan) % 2 != 0) return;
        
        if(x == target[0] && y == target[1] && dist == k){
            answer = sb.toString();  
            return;
        } 
        
        for(int i = 0 ; i<4; i++){
            int nx = x + dirX[i];
            int ny = y + dirY[i];
            
            if(
                nx > 0 && nx <= range[0] &&
                ny > 0 && ny <= range[1]
            ){
                dfs(new int[] {nx,ny}, target, range,k, dist+1, sb.append(dirChar[i]));
                if(!answer.isEmpty()) return;
                sb.delete(dist,dist+1); // 백트래킹
            }
            
        }
        
        
        
        
        
    }
}