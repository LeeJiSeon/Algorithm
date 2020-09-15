import java.util.*;
class Sol2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tree = new int[n];
        int left = 1, right = 2000000000;
        for(int i = 0 ; i < n ; i++)
            tree[i] = sc.nextInt();
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for(int t : tree) {
                if(t > mid)
                    sum += (t - mid);
            }
            if(sum >= m)    left = mid + 1;
            else    right = mid - 1;
        }
        System.out.println(right);
    }
}
