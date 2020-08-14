import java.util.List;
import java.util.ArrayList;
class Compressed {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>(); 
        List<String> indexlist = new ArrayList<>();
        
        for(int i = 0 ; i < 26 ; i++) {
            char w = (char)('A' + i);
            indexlist.add(String.valueOf(w));
        }
        
        for(int i = 0 ; i < msg.length() ;) {
            StringBuffer sb = new StringBuffer(msg.substring(i, i+1));
            int index = 0;
            
            while(indexlist.contains(sb.toString())) {
                index = indexlist.indexOf(sb.toString()) + 1;
                if((i++) == msg.length()-1) {
                    break;
                }
                sb.append(msg.substring(i, i+1));
            }
            result.add(index);
            indexlist.add(sb.toString());
        }
        answer = new int[result.size()];
        for(int i =  0 ; i < answer.length ; i++)
            answer[i] = result.get(i);
        return answer;
    }
}
