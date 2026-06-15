import java.util.*;

class Solution {
    int[][] lUsers;
    int[] lEmoticons;
    int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        lUsers = users;
        lEmoticons = emoticons;
        calcPrice(0, new int[emoticons.length]);
        return answer;
    }
    
    private void calcUsers(int[] currentDiscounts){
        int subsSum = 0;
        int soldTotal = 0;
        for(int[] user : lUsers){
            int buyTotal = 0;
            int buyRate = user[0];
            int subsPrice = user[1];
            for(int i = 0; i<lEmoticons.length; i++){
                if(buyRate <= currentDiscounts[i]){
                    buyTotal += lEmoticons[i] - ((lEmoticons[i] / 100) * currentDiscounts[i]);
                }
            }
            if(buyTotal >= subsPrice) subsSum ++;
            else soldTotal += buyTotal;
        }
        if(answer[0] < subsSum){
            answer[0] = subsSum;
            answer[1] = soldTotal;
        } else if(answer[0] == subsSum){
            answer[1] = Math.max(answer[1],soldTotal);
        }
    }
    
    private void calcPrice(int idx, int[] currentDiscounts){
        if(idx == currentDiscounts.length){
            calcUsers(currentDiscounts);
            return;
        }
        
        for(int rate : new int[] {10,20,30,40}){
            currentDiscounts[idx] = rate;
            calcPrice(idx + 1, currentDiscounts);
        }
    }
}