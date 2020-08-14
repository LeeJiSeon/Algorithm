import java.io.*;
public class Sol2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 1 ; i < n ; i++) {
            int sum = i, tmp = i;
            while(tmp != 0) {
                sum += (tmp % 10);
                tmp /= 10;
            }
            if(sum == n) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
