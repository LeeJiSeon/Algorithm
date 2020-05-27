import java.util.Arrays;
class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);
        while(j >= 0 && i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
                j--;
            }
            else    j--;
            answer++;
        }
        return answer;
    }
}