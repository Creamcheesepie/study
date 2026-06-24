import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets,(t1, t2) -> t1[1] - t2[1]);
        
        int lastPos = -1;
        for(int i = 0; i<targets.length; i++){
            int[] target = targets[i];
            if(target[0] >= lastPos) {
                answer++;
                lastPos = target[1];
            }
        }
        
        return answer;
    }
}