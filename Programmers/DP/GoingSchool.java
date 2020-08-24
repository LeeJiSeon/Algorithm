class GoingSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] area = new int[n][m];
        int mod = 1000000007;
        
        for(int[] puddle : puddles)
            area[puddle[1]-1][puddle[0]-1] = -1;
        
        area[0][0] = 1;        
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m ; j++) {
                if(area[i][j] == -1) {
                    area[i][j] = 0;
                    continue;
                }
                if(i != 0)
                    area[i][j] += area[i-1][j];
                if(j != 0)
                    area[i][j] += area[i][j-1];
                
                area[i][j] %= mod;
            }
        return area[n-1][m-1];
    }
}
