class Solution {
    public String solution(int n) {
        return to124String(n);
    }
    
    private String to124String(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n % 3 == 0){
                sb.insert(0,4);
                n -= 3;
            }else{
                sb.insert(0,n % 3);
            }
            n /= 3;
        }
        return sb.toString();
    }
}