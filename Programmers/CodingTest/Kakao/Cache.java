import java.util.*;
class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for(int i = 0 ; i < cities.length ; i++)
            cities[i] = cities[i].toLowerCase();
        List<String> list = new ArrayList<>();
        for(String city : cities) {
            if(list.contains(city)) {
                list.remove(city);
                list.add(city);
                answer++;
            }
            else {
                list.add(city);
                if(list.size() > cacheSize)
                    list.remove(0);
                answer += 5;
            }
        }
        return answer;
    }
}