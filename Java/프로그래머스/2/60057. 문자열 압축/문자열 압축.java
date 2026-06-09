class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        
        for(int size = 1; size <=n/2; size++){
            StringBuilder sb = new StringBuilder();
            String before = s.substring(0,size);
            int cnt = 1;
            
            for(int i = size; i<n; i += size){
                int end = Math.min(n, i + size);
                
                String current = s.substring(i,end);
                if(before.equals(current)){
                    cnt++;
                } else {
                    sb.append(cnt > 1 ? cnt : "").append(before);
                    before = current;
                    cnt = 1;
                }
            }
            sb.append(cnt > 1 ? cnt : "").append(before);
            answer = Math.min(sb.length() , answer);
        }
        
        
        return answer;
    }
}