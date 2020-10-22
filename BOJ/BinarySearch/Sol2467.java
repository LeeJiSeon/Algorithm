import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
		    arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0, end = N-1;
		int min = Integer.MAX_VALUE;
		int[] ans = new int[2];
		
		while(start < end) {
		    int sum = arr[start] + arr[end];
		    if(Math.abs(sum) < min) {
		        min = Math.abs(sum);
		        ans[0] = arr[start];    ans[1] = arr[end];
		    }
		    
		    if(sum < 0)     start++;
		    else    end--;
		}
		
		System.out.println(ans[0] + " " + ans[1]);
		br.close();
	}
}
