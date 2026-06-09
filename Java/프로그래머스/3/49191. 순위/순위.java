class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n + 1][n + 1];
        
        for(int i = 0; i< results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            graph[a][b] = 1;
            graph[b][a] = 2;
        }
        
        // 플로이드 워셜 알고리즘 응용
        // 만약 i -> k 승 ,  k -> j 승이면 i -> j 승이다.
        // 위 관계를 통해 유추가능한 다른 플레이도 채워넣기
        for(int k= 1; k<n+1;k++){
            for(int i = 1; i<n+1; i++){
                for(int j = 1; j<n+1; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = 2;
                    }
                }
            }
        }
        
        // 알고 있는 결과 = n - 1 -> 순위를 알 수 있음
        for(int i = 1; i<n+ 1;i ++){
            int[] res = graph[i];
            int cnt = 0;
            for(int t : res){
                if(t > 0) cnt++;
            }            
            if(cnt == n -1) answer++;
        }
        
        return answer;
    }
}