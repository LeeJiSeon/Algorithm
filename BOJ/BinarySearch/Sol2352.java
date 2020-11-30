import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Sol2352
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
		    arr[i] = Integer.parseInt(st.nextToken());
		    
		int[] lis = new int[n];
		lis[0] = arr[0];
		int idx = 1;
		
		for(int i = 1; i < n; i++) {
		    if(lis[idx-1] < arr[i])
		        lis[idx++] = arr[i];
		    else if(lis[0] > arr[i])
		        lis[0] = arr[i];
		    else {
		        int pos = Arrays.binarySearch(lis, 0, idx, arr[i]);
		        lis[pos < 0 ? -pos-1 : pos] = arr[i];
		    }
		}
		
		System.out.println(idx);
		br.close();
	}
}
