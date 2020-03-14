import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Hindex {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < citations.length ; i++) {
            list.add(citations[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);

        for(int h = 0 ; h < list.size() ; h++){
            if(h + 1 >= list.get(h)){
                citations[h] = list.get(h);
            }
            else
                citations[h] = h + 1;
        }
        Arrays.sort(citations);
        return citations[citations.length - 1];
    }
}