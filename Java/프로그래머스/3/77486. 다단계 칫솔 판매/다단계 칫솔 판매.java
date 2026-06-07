import java.util.*;

class Solution {
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        boolean[] visited;
        Map<String,Integer> indexMap = new HashMap<>();
        Map<String,String> parent = new HashMap<>(); // key값에 자신 value 값에 부모(추천인)
        int[] answer = new int[enroll.length];
        int totalMembers = enroll.length;

        visited = new boolean[totalMembers];
        
        for(int i = 0; i<totalMembers; i++){
            indexMap.put(enroll[i],i);
        }
        
        for(int i = 0; i<totalMembers; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i<seller.length; i++){
            String currentName = seller[i];
            int money = amount[i] * 100;
            
            while(!currentName.equals("-") && money > 0){
                int comm = money / 10;
                answer[indexMap.get(currentName)] += money - comm;
                
                currentName = parent.get(currentName);
                money = comm;
            }
            
        }       
        return answer;
    }
}