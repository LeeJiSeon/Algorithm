import java.util.Arrays;
class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        return binarySearch(n, times, times[times.length - 1]);
    }
    
    private long binarySearch(int n, int[] times, long max) {
        long left = 1, right = max * n;
        long mid = 0, answer = Long.MAX_VALUE;
        while(left <= right) {
            mid = (left + right) / 2;
            if(isPassed(n, times, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else  left = mid + 1;
        }
        return answer;
    }
    
    private boolean isPassed(int n, int[] times, long mid) {
        long count = 0;
        for(int i = 0 ; i < times.length ; i++)
            count += mid / times[i];
        if(count >= n)  return true;
        else    return false;
    }
}
