class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long origin = (long)w * (long)h;
        
        //대각선 좌표를 포함하는 사각형을 빼고 세기?
        // 0,0 ~ w,h 까지의 길이... 그래프... 
        // 근데 1억 이하의 자연수니까 완전탐색은 개에바 아님? 1억 * 1억일수도 있잖아...?
        // 그럼 수학적으로 빠르게 풀 수 있는 방법이 있다는건데
        // 보자... 
        int gcd = gcd(w,h);
        answer = origin - (w + h - gcd);
        
        return answer;
    }
    
    private int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a% b);
    }
}