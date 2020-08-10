import java.util.List;
import java.util.ArrayList;
class GameofN {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        List<Character> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        while(list.size() < t * m) {
            int index = list.size();
            int q, r;
            q = num / n;
            r = num % n;
            list.add(nums[r]);
            while(q > 0) {
                r = q % n;
                q = q / n;
                list.add(index, nums[r]);
            }
            num++;
        }
        for(int i = 0 ; i < t ; i++) {
            sb.append(list.get(i*m + (p-1)));
        }
        return sb.toString();
    }
}