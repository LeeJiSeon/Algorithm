import java.util.*;
class Tuple {
    public int[] solution(String s) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                sb.append(s.charAt(i));
            else if(sb.length() > 0) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
                sb = new StringBuilder();
            }
        }
        answer = new int[map.size()];
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = Integer.parseInt(keySet.get(i));
        }

        return answer;
    }
}