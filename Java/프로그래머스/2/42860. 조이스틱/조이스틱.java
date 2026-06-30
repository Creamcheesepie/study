class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] chars = name.toCharArray();
        int len = name.length();
        
        for(int i = 0; i<len; i++){
            char c = chars[i];
            int temp = c - 'A' > 'Z' - c + 1? 'Z' - c + 1 : c - 'A'; // Z에서 갈 때에는 +1 해줘야함(Math.abs 쓰는 것도 방법인데 걍 Z쓰기로)
            answer += temp;
        }
        
        
        int minDist = len - 1;
        for(int i = 0; i<len; i++){
            int nextIdx = i + 1;
            while(nextIdx < len && chars[nextIdx] == 'A'){
                nextIdx++;
            }
            
            int moveRight = (i*2) + (len - nextIdx); // 오른쪽 먼저 들리고 왼쪽 순회
            int moveLeft = (len - nextIdx) * 2 + i; // 왼쪽 먼저 들리고 오른쪽 순회
            
            int minMove = Math.min(moveRight, moveLeft);
            minDist = Math.min(minDist,minMove);
        }
        
        answer += minDist;
        return answer;
    }
}