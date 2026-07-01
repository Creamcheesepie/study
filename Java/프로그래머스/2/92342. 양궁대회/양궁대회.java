class Solution {
    int diff = 0;
    int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        int[] player = new int[info.length];
        dfs(player, info, info.length - 1,n,0);

        
        if(diff == 0) return new int[] {-1};
        return answer;
    }
    
    private void dfs(int[] player,int[] info, int level, int leftArrow, int point){
        if(level == -1){
            int sum = 0;
            int eSum = 0;
            
            player[10] += leftArrow;
            for(int i = 0; i<info.length; i++){
                if(player[i] > 0){
                    sum += 10 - i;
                } else if(info[i] > 0){
                    eSum += 10 - i;
                }
            }
            if(sum - eSum > diff){
                diff = sum - eSum;
                answer = player.clone();
                
            }
            player[10] = 0;
            return;
        }
   
        int needArrow = info[level] + 1;
        if(leftArrow >= needArrow){
            player[level] = needArrow;
            dfs(player ,info, level - 1, leftArrow - needArrow, point); 
            player[level] = 0;
        } 
        dfs(player, info, level - 1, leftArrow , point);
    }
}