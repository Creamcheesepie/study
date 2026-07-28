class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited= new boolean[n];
        int answer = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(computers, i, visited);
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, int idx, boolean[] visited){
        int[] com = computers[idx];
        for(int i = 0; i<com.length; i++){
            if(com[i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(computers, i, visited);
            }
        }
    }
}