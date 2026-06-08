import java.util.Arrays; 

class Solution {
    public int solution(int n, int[] money) {
        int answer = 1;
        int l = money.length;
        // DP가 맞았구나!
        // 근데 이중 반복문 쓰면 너무 처리시간이 길어지지 않을까?
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        Arrays.sort(money); // 순환 편의를 위해 내림차순 정렬
        for(int i = 0; i<money.length; i++){// 외부 동전 인덱스 순환
            int coin = money[i];
            for(int j = coin; j<n+1; j ++){
                
                // coin으로 해당 money를 만들 수 있는 횟수
                int temp = dp[j] + dp[j-coin];
                dp[j] = temp % 1_000_000_007;
            }
        }
        
        return dp[n];
    }
}