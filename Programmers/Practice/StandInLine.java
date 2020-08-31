import java.util.*;
class StandInLine {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long factorial = 1;
        List<Integer> nums = new ArrayList<>();
        int index = 0, q;
        
        for(int i = 1 ; i < n ; i++)
            factorial *= i;
        for(int i = 0 ; i < n ; i++)
            nums.add(i + 1);
        
        k--;
        n--;
        while(true) {
            q = (int) (k / factorial);
            answer[index++] = nums.remove(q);
            if(nums.isEmpty())
                break;
            k %= factorial;
            factorial /= (n--);           
        }
        return answer;
    }
    
}
