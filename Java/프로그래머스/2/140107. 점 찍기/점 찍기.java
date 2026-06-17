class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // x좌표를 기준으로 계산한다.
        // x좌표를 k만큼 증가시킴
        for(long x = 0; x<=d; x+=k){
            // d 안에 들어있는 원 위의 점 위치 (x * x) + (y * y) = d * d 
            // 이를 y값 기준으로 변환 = y * y = d * d - x * x
            // x 값에 대해 y값의 최댓값을 구한다 : y * y <= d * d - x * x;
            long maxY = (long) Math.sqrt((long)d * d - x * x);
            // k의 배수만큼 y의 값이 있을 수 있으니 k로 나눠주고, 시작점인 0인 경우를 하나 더하면 된다. 
            answer += (maxY / k) + 1;
        }
        
        return answer;
    }
}