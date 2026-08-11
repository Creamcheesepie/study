class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean isFirst = true;
        
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c == ' '){
                isFirst = true;
            } else if(isFirst){
                isFirst = false;
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}