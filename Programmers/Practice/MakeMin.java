import java.util.Arrays;
class MakeMin {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int idx;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < A.length ; i++) {
            idx = A.length - i - 1;
            answer += (A[i] * B[idx]);
        }
        return answer;
    }
}