class Solution {
    public int solution(int n) {
        return pivoFor(n);
    }
    
    private int pivo(int n){
        if(n <= 1) return n;
        else return (pivo(n-1) + pivo(n-2)) % 1234567;
    }
    
    private int pivoFor(int n){
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 1; i<=n; i++){
            c = (a + b) % 1234567;
            b = a;
            a = c;
        }
        
        return c % 1234567;
    }
}