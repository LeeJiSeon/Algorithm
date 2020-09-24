import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Sol11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int sum = 0;
        
        for(int i = 0 ; i < n ; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++)
            sum += (nums[i] * (n-i));
        
        System.out.println(sum);
    }
}
