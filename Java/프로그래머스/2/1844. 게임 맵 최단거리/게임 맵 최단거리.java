import java.util.*;

class Solution {
    int[] xDir = new int[] {1,-1,0,0};
    int[] yDir = new int[] {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        deque.offer(new int[] {0,0,1});
        visited[0][0] = true;
        
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];
            if(curX == maps.length - 1 && curY == maps[0].length - 1) return dist;
            
            for(int i = 0; i<4; i++){
                int nx = curX + xDir[i];
                int ny = curY + yDir[i];
                
                if(
                    nx > -1 && nx < maps.length && 
                    ny > -1&& ny < maps[nx].length &&
                    !visited[nx][ny] &&
                    maps[nx][ny] == 1
                  ){
                    visited[nx][ny] = true;
                    deque.offer(new int[] {nx,ny, dist+1});
                }
            }
        }
        
        return -1;
    }
}