import java.util.Arrays;

class Hindex_other {
    public int solution(int[] citations) {
        int max = 0;
        int min = 0;
        Arrays.sort(citations);

        for(int i = citations.length - 1 ; i >= 0 ; i--){
            min = Math.min(citations[i], citations.length - i);
            if(max < min)
                max = min;
        }

        return max;
    }
}