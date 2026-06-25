class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            long num = begin + i;
            if(num == 1) {
                answer[i] =0;
            } else {
                answer[i] = (int) getMaxDivisor(num);
            }
        }
        
        return answer;
    }
    
    private long getMaxDivisor(long n){
        long max = 1;
        for(long i = 2; i * i <= n; i++){
            if(n % i == 0 ) {
                max = i;
                if(n / i <= 10_000_000) return n / i;
            }
        }
        
        return max;
    }
}