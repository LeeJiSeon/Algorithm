import java.util.*;

class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        List<Integer> list_l = new ArrayList<>();
        List<Integer> list_r = new ArrayList<>();
        for(int i : reserve)
            list_r.add(i);

        for(int l : lost) {
            if(list_r.contains(l))
                list_r.remove(list_r.indexOf(l));
            else
                list_l.add(l);
        }

        answer -= list_l.size();

        for(int l : list_l) {
            if(list_r.contains(l-1)) {
                answer++;
                list_r.remove(list_r.indexOf(l-1));
            }
            else if(list_r.contains(l+1)) {
                answer++;
                list_r.remove(list_r.indexOf(l+1));
            }
        }
        
        return answer;
    }

}