import java.util.HashMap;

class Spy_clothes {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        int answer = 1;

        for(int i = 0 ; i < clothes.length ; i++){
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String key : clothesMap.keySet())
            answer *= (clothesMap.get(key) + 1);

        return answer - 1;
    }
}