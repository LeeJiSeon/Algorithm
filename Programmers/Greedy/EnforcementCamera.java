import java.util.Arrays;
class EnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        for(int[] route : routes) {
            if(route[0] > camera) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
