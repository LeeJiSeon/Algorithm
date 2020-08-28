import java.util.*;
class Sol2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c = sc.nextInt();
        int[] home = new int[n];
        for(int i = 0 ; i < n ; i++)
            home[i] = sc.nextInt();
        Arrays.sort(home);
        
        int left = 1, right = home[n-1] - home[0];
        int d = 0, answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int start = home[0];
            int cnt = 1;
            for(int i = 1 ; i < n ; i++) {
                d = home[i] - start;
                if(mid <= d) {
                    cnt++;
                    start = home[i];
                }
            }            
            if(cnt >= c) {
                answer = mid;
                left = mid + 1;
            } else    right = mid - 1;               
        }
        System.out.println(answer);
    }
}
