import java.util.*;

class Solution {
    int[] wDir = new int[] {1,-1,0,0};
    int[] hDir = new int[] {0,0,1,-1};
    
    public int solution(String[] board) {
        int answer = 0;
        int width = board[0].length();
        int height = board.length;
        int[] start = new int[3];
        boolean[][] visited = new boolean[height][width];
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        for(int h = 0; h<height; h++){
            for(int w = 0; w<width; w++){
                if(board[h].charAt(w) == 'R'){
                    start[0] = h;
                    start[1] = w;
                }
            }
        }
        
        deque.offer(start);
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            int currentH = current[0];
            int currentW = current[1];
            int cnt = current[2];
            if(board[currentH].charAt(currentW) == 'G') return cnt;
            
            for(int i = 0; i<4; i++){
                int nh = current[0];
                int nw = current[1];
                while(true){
                    int th = nh + hDir[i];
                    int tw = nw + wDir[i];
                    if(
                        th < 0 || th >= height ||
                        tw < 0 || tw >= width ||
                        board[nh + hDir[i]].charAt(nw + wDir[i]) == 'D'
                    ) break;
                    nh = nh + hDir[i];
                    nw = nw + wDir[i];
                }
                
                if(!visited[nh][nw]){
                    deque.offer(new int[]{nh,nw,cnt+1});
                    visited[nh][nw] = true;
                }
            }
        }
        
        
        
        return -1;
    }
}