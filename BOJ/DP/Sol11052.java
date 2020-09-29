import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[n+1];
        for(int i = 1 ; i <= n ; i++)
            card[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= i/2 ; j++) {
                int k = i - j;
                card[i] = Math.max(card[i], card[j] + card[k]);
            }
        }
        
        System.out.println(card[n]);
    }
}
