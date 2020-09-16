import java.util.*;
class Sol1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long left = 0, right = Integer.MAX_VALUE;
        int[] lan = new int[k];
        for(int i = 0 ; i < k ; i++)
            lan[i] = sc.nextInt();
        sc.close();
        
        while(left <= right) {
            long mid = (left + right) / 2;
            int sum = 0;
            for(int l : lan) {
                sum += (l / mid);
            }
            if(sum >= n)    left = mid + 1;
            else    right = mid - 1;
        }
        System.out.println(right);
    }
}
