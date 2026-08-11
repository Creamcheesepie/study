import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // 각 행렬의 원소값을 곱한 값이 최소가 되는 경우 -> 한 행렬의 가장 큰 값과 가장 적은 값을 서로 곱해주면됨.
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;
        for(int i = 0, b = n -1; i<n; i ++ , b--){
            answer += A[i] * B[b];
        }

        return answer;
    }
}