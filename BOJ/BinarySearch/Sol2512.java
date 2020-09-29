import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sol2512{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0, right = 0, sum = 0;
        int[] area = new int[n];
        for(int i = 0 ; i < n ; i++) {
            area[i] = Integer.parseInt(st.nextToken());
            sum += area[i];
            right = Math.max(right, area[i]);
        }
        int money = Integer.parseInt(br.readLine());
        
        if(money >= sum) {
            System.out.println(right);
            return;
        }
        
        while(left <= right) {
            sum = 0;
            int mid = (left + right) / 2;
            for(int i : area)
                sum += (i <= mid ? i : mid);
            if(sum <= money)    left = mid + 1;
            else    right = mid - 1;
        }
        
        System.out.println(right);
    }
}
