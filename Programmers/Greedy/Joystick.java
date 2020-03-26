import java.util.*;

class Joystick {
    public int solution(String name) {
        int answer = 0, index = 0;
        List<Boolean> check = new ArrayList<>();
        for(int i = 0 ; i < name.length() ; i++)
            if(name.charAt(i) != 'A')   check.add(false);
            else    check.add(true);

        while(check.contains(false)) {
            if(check.get(index)) {
                int lindex = index;
                int rindex = index;
                int left = 0, right = 0;
                while(check.get(lindex)) {
                    lindex = (lindex == 0) ? check.size() - 1 : lindex-1;
                    left++;
                }
                while(check.get(rindex)) {
                    if(rindex == check.size()-1) {
                        right = 100;
                        break;
                    }
                    rindex++;
                    right++;
                }

                if(left < right) {
                    answer += left;
                    index = lindex;
                }
                else {
                    answer += right;
                    index = rindex;
                }

            }
            check.set(index, true);
            answer += addAlphabet(name.charAt(index));
        }
        return answer;
    }

    private static int addAlphabet(char alpha) {
        if(alpha - 'A' < 'Z' - alpha + 1)
            return alpha - 'A';
        else
            return 'Z' - alpha + 1;
    }
}