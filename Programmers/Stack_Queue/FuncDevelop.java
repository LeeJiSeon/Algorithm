import java.util.List;
import java.util.ArrayList;

class FuncDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] days = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        int day = -1;
        int count = 0;

        for(int i = 0 ; i < days.length ; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0)
                days[i]++;
        }

        for(int d : days) {
            if(day == -1) {
                day = d;
                count++;
            }
            else {
                if(day >= d)
                    count++;
                else{
                    day = d;
                    list.add(count);
                    count = 1;
                }
            }
        }
        list.add(count);

        answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++)
            answer[i] = list.get(i);

        return answer;
    }
}