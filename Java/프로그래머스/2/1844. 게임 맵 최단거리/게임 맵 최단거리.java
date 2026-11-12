import java.util.*;

class Solution {
    int[] xDir = new int[] {1,-1,0,0};
    int[] yDir = new int[] {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int xMax = maps.length;
        int yMax = maps[0].length;
        boolean[][] visited = new boolean[xMax][yMax];
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {0,0,1});
        visited[0][0] = true;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if(x == xMax -1 && y == yMax -1) return dist;
            
            for(int i =0; i<4; i++){
                int nx = x + xDir[i];
                int ny = y + yDir[i];
                
                if(
                    nx < 0 || nx >= xMax ||
                    ny < 0 || ny >= yMax ||
                    maps[nx][ny] == 0 ||
                    visited[nx][ny]
                ) continue;
                
                visited[nx][ny] = true;
                deque.offer(new int[] {nx,ny,dist + 1});
            }
        }
        
        
        return -1;
    }
}