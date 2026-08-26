import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        int minIdx = 0;
        Arrays.sort(people);
        
        for(int i = n -1 ; i>= minIdx; i--){
            int curr = people[i];
            if(curr + people[minIdx] <= limit)minIdx++;
            answer++;
        }
        
        
        return answer;
    }
}