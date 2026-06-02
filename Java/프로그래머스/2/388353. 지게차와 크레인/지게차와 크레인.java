import java.util.*;

class Solution {
    int[] dirH = new int[] {1 , -1 , 0, 0};
    int[] dirW = new int[] {0 , 0, 1 ,-1 };
    public int solution(String[] storage, String[] requests) {
        int maxH = storage.length;
        int maxW = storage[0].length();
        char[][] graph = new char[maxH][maxW];
        int answer = maxH * maxW;
        
        for(int h = 0; h<maxH; h++){
            for(int w = 0; w<maxW; w++){
                graph[h][w] = storage[h].charAt(w);
            }
        }
        
        for(String rq : requests){
            char c = rq.charAt(0);
            if(rq.length() == 1){
                Deque<int[]> dq = new ArrayDeque<>();
                boolean[][] visited = new boolean[maxH][maxW];
                for(int h = 0; h<maxH ;h++){
                    if(graph[h][0] == c || graph[h][0] == '.') dq.offer(new int[] {h,0});
                    if(graph[h][maxW-1] == c || graph[h][maxW-1] == '.') dq.offer(new int[] {h,maxW-1});
                }
                for(int w = 1; w<maxW-1; w++){
                    if(graph[0][w] == c || graph[0][w] == '.') dq.offer(new int[] {0,w});
                    if(graph[maxH-1][w] == c || graph[maxH-1][w] == '.') dq.offer(new int[] {maxH-1,w});
                }
                
                while(!dq.isEmpty()){
                    int[] cur = dq.poll();
                    int h = cur[0]; int w = cur[1];
                    visited[h][w] = true;
                    if(graph[h][w] == c) {
                        answer --;
                        graph[h][w] = '*';
                    } else if(graph[h][w] == '.'){
                        for(int i = 0; i<4; i++){
                            int nh = h + dirH[i];
                            int nw = w + dirW[i];
                            if(nh > 0 && nh<maxH &&
                               nw > 0 && nw<maxW &&
                               !visited[nh][nw]
                              ){
                                dq.offer(new int[] {nh,nw});
                            }
                        }
                    }
                }
            } else {
                for(int h = 0; h<maxH ; h++){
                    for(int w = 0; w<maxW; w++){
                        if(graph[h][w] == c){
                            answer --;
                            graph[h][w] = '*';
                        }
                    }    
                }
                
            }
            
            for(int h = 0; h<maxH ; h++){
                for(int w = 0; w<maxW; w++){
                    // System.out.print(graph[h][w]);
                    if(graph[h][w] == '*'){
                        graph[h][w] = '.';
                    }
                }
                // System.out.println();
            }
            // System.out.println("----------------");
            
        }
        
        return answer;
    }
    
    
}