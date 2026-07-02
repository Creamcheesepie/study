import java.util.Arrays;

class Solution {
    boolean[] visited;
    
    public int solution(int[] cards) {
        int answer = 1;
        int n = cards.length;
        visited = new boolean[n];
        int[] res = new int[n]; 
        
        int idx = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                res[idx++] = dfs2(cards,i,0);
            }
        }
        
        Arrays.sort(res);
        if(idx < 2) return 0;
        else return res[n-1] * res[n-2]; 
    }
    
    int max = 0;
    private int dfs(int[] cards, int box, int point){
        if(visited[box]){
            return point;
        }
        
        int cur = 0;
        if(!visited[box]){
            int card = cards[box];
            int index = card - 1;
            visited[box] = true;
            cur += dfs(cards,index, point + 1);
        }
        
        return cur;
    }
    
    // 개선된 버전
    private int dfs2(int[] cards, int box, int point){
        if(visited[box]){
            return point;
        }
        
        visited[box] = true;
        int nextBox = cards[box] - 1;
        
        return dfs(cards, nextBox, point + 1);
    }
}