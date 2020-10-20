import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
		    arr[i] = Integer.parseInt(st.nextToken());
		    
	    int first = 0, second = 0;
	    int sum = 0, ans = 100001;
	    while(true) {
	        if(sum >= S) {
	            ans = Math.min(ans, second-first);
	            sum -= arr[first++];
	        } else if(second == N)  break;
	        else  sum += arr[second++];
	    }
	    
	    System.out.println((ans == 100001) ? 0 : ans);
	    br.close();
	}
}
