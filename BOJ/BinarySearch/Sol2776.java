import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Sol2776 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 0; test_case < T; test_case++) {
		    int N = Integer.parseInt(br.readLine());
		    int[] note1 = new int[N];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i = 0; i < N; i++)
		        note1[i] = Integer.parseInt(st.nextToken());
		    Arrays.sort(note1);
		    
		    int M = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine());
		    
		    for(int i = 0; i < M; i++) {
		        int n = Integer.parseInt(st.nextToken());
		        int left = 0, right = N-1, val = 0;
		        
		        while(left <= right) {
		            int mid = (left + right) / 2;
		            
		            if(n == note1[mid]) {
		                val = 1;
		                break;
		            } else if(n < note1[mid])     right = mid - 1;
		            else    left = mid + 1;
		        }
		        
		        sb.append(val);
		        sb.append("\n");
		        
		    }
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
