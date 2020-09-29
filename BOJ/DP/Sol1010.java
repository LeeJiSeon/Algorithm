/*
파스칼의 삼각형
- nCr = n-1Cr + n-1Cr-1
- nC0 = nCn = 1
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int a = 0 ; a < t ; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] bridge = new int[31][31];
            
            for(int i = 0 ; i < 31 ; i++) {
                bridge[i][0] = bridge[i][i] = 1;
                for(int j = 1 ; j < i ; j++)
                    bridge[i][j] = bridge[i-1][j] + bridge[i-1][j-1];
            }
            
            System.out.println(bridge[m][n]);
        }
    }
}
