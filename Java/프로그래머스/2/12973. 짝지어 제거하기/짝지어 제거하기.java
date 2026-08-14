class Solution
{
    public int solution(String s)
    {
        // 스택을 쓰면 되는 문제.
        int n = s.length();
        int index = 0;
        char[] stack = new char[n];
        
        for(int i = 0; i<n; i++){
            char current = s.charAt(i);
            if(index == 0){
                stack[index++] = current; 
            } else if(stack[index-1] == current){
                index --;
            } else{
                stack[index++] = current;
            }
        }
        
        if(index == 0) return 1;
        else return 0;
    }
}