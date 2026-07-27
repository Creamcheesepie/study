class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int level,int number){
        if(level == numbers.length && number == target) return 1;
        else if(level == numbers.length) return 0;
        int max = 0;
        
        max += dfs(numbers, target, level + 1, number + numbers[level]);
        max += dfs(numbers, target, level + 1, number - numbers[level]);
        
        return max;
    }
}