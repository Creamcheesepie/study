import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = points.length + 1;
        List<List<int[]>> moveHistory = new ArrayList<>();
        
        // BFS + DP?
        // 동일 지점에서 충돌이 여러번 날 수도 있음. -> 각 로봇들의 특정 시점마다 위치를 검사해서 중복된 위치에 있다면 answer++;
        // 개별 로봇들을 각 루트별로 이동
        for(int i = 0; i < routes.length; i++){
            List<int[]> routeMove = new ArrayList<int[]>();
            moveHistory.add(routeMove);
            int[] route = routes[i];
            int[] depart = points[route[0] - 1];
            routeMove.add(depart);
            
            for(int p : route){
                int[] via = points[p - 1];
                while(via[0] != depart[0]){
                    if(via[0]>depart[0]){
                        depart[0] ++;
                    } else {
                        depart[0]--;
                    }
                    routeMove.add(new int[] {depart[0],depart[1]});
                }
                
                while(via[1] != depart[1]){
                    if(via[1] > depart[1]){
                        depart[1] ++;
                    } else {
                        depart[1] --;
                    }
                    routeMove.add(new int[] {depart[0],depart[1]});
                }
                depart = new int[] {via[0],via[1]};
            }
        }
        
        int maxTime = 0;
        for(List<int[]> temp : moveHistory){
            maxTime = Math.max(temp.size(), maxTime);
        }
        
        for(int i = 0; i<maxTime; i++){
            Map<String ,Integer> locationMap = new HashMap<>();
            
            for(List<int[]> move : moveHistory){
                if(i<move.size()){
                    int[] pos = move.get(i);
                    String posKey = pos[0] + "," + pos[1];
                    locationMap.put(posKey, locationMap.getOrDefault(posKey,0) + 1);
                }
            }
            
            for(Integer cnt : locationMap.values()){
                if(cnt > 1) answer++;
            }
        }
        
        return answer;
    }
}