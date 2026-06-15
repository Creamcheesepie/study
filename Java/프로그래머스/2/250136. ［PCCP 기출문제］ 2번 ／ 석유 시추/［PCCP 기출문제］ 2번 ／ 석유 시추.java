import java.util.*;

class Solution {
    public int solution(int[][] land) {
        return bfsSolution(land);
    }
    
    // BFS 한번으로 처리할 수 있게 힘내기!
    private int bfsSolution(int[][] land){
        int answer = 0;
        int landH = land.length;
        int landW = land[0].length;
        int[] dirH = new int[] {1, -1, 0, 0};
        int[] dirW = new int[] {0, 0, 1, -1};
        boolean[][] visited = new boolean[landH][landW];
        int[][] oilMap = new int[landH][landW];
        Map<Integer,Integer> oilSiteMap = new HashMap<>();
        Deque<int[]> queue = new ArrayDeque<>();
        
        int siteCnt = 1;
        for(int w = 0; w<landW; w++){    
            for(int h = 0; h<landH; h++){
                int oilCount = 0;
                if(land[h][w] == 1 && !visited[h][w]){
                    queue.offer(new int[] {h, w});
                    oilCount++;
                    oilMap[h][w] = siteCnt;
                    visited[h][w] = true;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        for(int i = 0; i<4; i++){
                            int nH = cur[0] + dirH[i];
                            int nW = cur[1] + dirW[i];
                            
                            if(nH > -1 && nH < landH &&
                                nW > -1 && nW < landW &&
                               !visited[nH][nW] &&
                               land[nH][nW] == 1
                              ){
                                visited[nH][nW] = true;
                                oilCount++;
                                queue.offer(new int[] {nH,nW});
                                oilMap[nH][nW] = siteCnt;
                            }
                        }
                    }
                    oilSiteMap.put(siteCnt++,oilCount);
                }
            } 
        }
        
        for(int w = 0; w < landW; w++){
            int sum = 0;
            Set<Integer> siteSet = new HashSet<>();
            for(int h = 0; h<landH; h++){
                if(oilMap[h][w] > 0 && !siteSet.contains(oilMap[h][w])){
                    sum += oilSiteMap.get(oilMap[h][w]);
                    siteSet.add(oilMap[h][w]);
                }
            }
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
}