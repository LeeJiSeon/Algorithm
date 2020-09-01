import java.util.Arrays;
class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int index = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < B.length ; i++) {
            if(A[index] < B[i]) {
                answer++;
                index++;
            }
        }
        return answer;
    }
}
