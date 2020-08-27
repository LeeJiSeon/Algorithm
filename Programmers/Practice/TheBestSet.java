import java.util.*;
class TheBestSet {
    public int[] solution(int n, int s) {
        if(s < n) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        for(int i = 0 ; i < n ; i++)
            answer[i] = s / n;
        if(s - (s/n)*n != 0)
            for(int i = 0 ; i < s-(s/n)*n ; i++)
                answer[i]++;
        Arrays.sort(answer);
        return answer;
    }
}
