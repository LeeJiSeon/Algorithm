import java.util.*;
class Printer {
    public static int solution(int[] priorities, int location) {
        int answer = location;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : priorities)
            list.add(i);
        List<Integer> sorted = new ArrayList(list);
        Collections.sort(sorted);

        while(!list.isEmpty()) {
            if(list.get(0) < sorted.get(sorted.size() - 1)) {
                list.add(list.get(0));
                list.remove(0);
                answer = (answer > 0) ? answer-1 : answer-1+list.size();
            }
            else {
                count++;
                if(answer == 0) break;
                answer--;
                list.remove(0);
                sorted.remove(sorted.size() - 1);
            }
        }
        return count;
    }

}