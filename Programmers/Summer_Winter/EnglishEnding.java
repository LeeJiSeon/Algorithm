import java.util.*;
class EnglishEnding {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        char end = words[0].charAt(words[0].length()-1);
        for(int i = 1 ; i < words.length ; i++) {
            if(end != words[i].charAt(0) || list.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            list.add(words[i]);
            end = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}