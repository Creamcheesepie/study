class Solution {
    public int[] solution(String s) {
        int changeCnt = 0;
        int removeZeroSum = 0;
        
        while(!s.equals("1")){
            int cnt = 0;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    cnt++;
                }
            }
            changeCnt++;
            removeZeroSum += s.length() - cnt;
            s = Integer.toBinaryString(cnt);
        }
        
        return new int[] {changeCnt, removeZeroSum};
    }
}