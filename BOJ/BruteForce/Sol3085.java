import java.io.*;
class Sol3085 {
    static char[][] candies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int n = Integer.parseInt(br.readLine());
        candies = new char[n][n];
        for(int i = 0 ; i < n ; i++)
            candies[i] = br.readLine().toCharArray();
        
        for(int i = 0 ; i < n ; i++) {
            max = Math.max(max, cntColumn(i, n));
            max = Math.max(max, cntRow(i, n));
        }
        
        for(int i = 0 ; i < n-1 ; i++)
            for(int j = 0 ; j < n ; j++) {
                changeCandy(i, j, i+1, j);
                max = Math.max(max, cntColumn(j, n));
                max = Math.max(max, cntRow(i, n));
                max = Math.max(max, cntRow(i+1, n));
                changeCandy(i, j, i+1, j);
            }
        
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n-1; j++) {
                changeCandy(i, j, i, j+1);
                max = Math.max(max, cntColumn(j, n));
                max = Math.max(max, cntColumn(j+1, n));
                max = Math.max(max, cntRow(j+1, n));
                changeCandy(i, j, i, j+1);
            }
        System.out.println(max);
    }
    
    static void changeCandy(int i1, int j1, int i2, int j2) {
        char tmp = candies[i1][j1];
        candies[i1][j1] = candies[i2][j2];
        candies[i2][j2] = tmp;
    }
    
    static int cntColumn(int j, int n) {
        char candy = '0';
        int max = 0, cnt = 0;
        for(int i = 0 ; i < n ; i++) {
            if(candies[i][j] != candy) {
                candy = candies[i][j];
                max = Math.max(max, cnt);
                cnt = 1;
            }
            else    cnt++;
        }
        max = Math.max(max, cnt);
        return max;
    }
    
    static int cntRow(int i, int n) {
        char candy = '0';
        int max = 0, cnt = 0;
        for(int j = 0 ; j < n ; j++) {
            if(candies[i][j] != candy) {
                candy = candies[i][j];
                max = Math.max(max, cnt);
                cnt = 1;
            }
            else    cnt++;
        }
        max = Math.max(max, cnt);
        return max;
    }
}