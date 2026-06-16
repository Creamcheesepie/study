import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        
        Arrays.sort(plans,(p1,p2) -> {
            return timeToMinutes(p1[1]) - timeToMinutes(p2[1]); 
        });
        
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i<plans.length; i++){
            String[] currentWork = plans[i];
            
            int currentSt = timeToMinutes(currentWork[1]);
            int currentDr = Integer.parseInt(currentWork[2]);
            
            int nextSt = (i == plans.length - 1) ? Integer.MAX_VALUE : timeToMinutes(plans[i+1][1]);
            int timeLeft = nextSt - currentSt;
            
            if(timeLeft >= currentDr){
                result.add(currentWork[0]);
                timeLeft -= currentDr;
                
                while(
                    timeLeft > 0 &&
                    !stack.isEmpty()
                ){
                    int[] restWork = stack.pop();
                    if(timeLeft >= restWork[1]){
                        timeLeft -= restWork[1];
                        result.add(plans[restWork[0]][0]);
                    } else{
                        restWork[1] -= timeLeft;
                        stack.push(restWork);
                        timeLeft = 0;
                    }
                }
                
            } else{
                stack.push(new int[] {i,currentDr - timeLeft});
            }
        }
        
        while(!stack.isEmpty()){
            int[] restWork = stack.pop();
            result.add(plans[restWork[0]][0]);
        }
        
        String[] answer = new String[plans.length];
        for(int i = 0; i<plans.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private int timeToMinutes(String time){
        String[] bits = time.split(":");
        return (Integer.parseInt(bits[0]) * 60) + Integer.parseInt(bits[1]);
    }
}