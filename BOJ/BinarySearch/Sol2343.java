import java.util.*;
class Sol2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lesson = new int[n];
        int left = 0, right = 0;
        int answer = 0;
        
        for(int i = 0 ; i < n ; i++) {
            lesson[i] = sc.nextInt();
            right += lesson[i];
            left = Math.max(left, lesson[i]);
        }
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0, sum = 0;
            for(int l : lesson) {
                if(sum + l > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += l;
            }
            if(sum != 0)    cnt++;
            if(cnt <= m) {
                answer = mid;
                right = mid - 1;
            }
            else    left = mid + 1;
        }
        System.out.println(answer);
        sc.close();
    }
}
