import java.util.*;

class Solution {
    int[] discounts = new int[] {10,20,30,40};
    int maxSubs = 0;
    int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        getBestCase(0, new int[emoticons.length], users, emoticons);
        return new int[] {maxSubs, maxSales};
    }
    
    private void calcUsers(int[] currentDiscounts,int[][] users, int[] emoticons){
        int subsCnt = 0;
        int totalSales = 0;
       
        for(int[] user : users){
            int userDiscountLimit = user[0];
            int userSubsLimit = user[1];
            int purchaseAmount = 0;
            
            for(int i = 0; i<emoticons.length; i++){
                if(currentDiscounts[i] >= userDiscountLimit){
                    purchaseAmount += emoticons[i] * (100 - currentDiscounts[i]) / 100;
                }
            }
            
            if(purchaseAmount >= userSubsLimit){
                subsCnt++;
            } else {
                totalSales += purchaseAmount;
            }
        }
        
        if(subsCnt > maxSubs ||
            (subsCnt == maxSubs && totalSales > maxSales)
          ){
            maxSubs = subsCnt;
            maxSales = totalSales;
        }
    }
    
    private void getBestCase(int idx, int[] currentDiscounts,int[][] users, int[] emoticons){
        if(idx == currentDiscounts.length){
            calcUsers(currentDiscounts,users,emoticons);
            return;
        }
        
        for(int rate : discounts){
            currentDiscounts[idx] = rate;
            getBestCase(idx + 1, currentDiscounts,users,emoticons);
        }
    }
}