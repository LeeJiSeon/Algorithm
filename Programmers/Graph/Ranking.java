import java.util.*;
class Ranking {
    public int solution(int n, int[][] results) {
        int max = 987654321;
        int[][] map = new int[n+1][n+1];
        boolean[] check = new boolean[n+1];
        int answer = 0;
        
        for(int i = 1 ; i <= n ; i++)
            Arrays.fill(map[i], max);
        
        for(int[] result : results)
            map[result[0]][result[1]] = 1;
        
        for(int k = 1 ; k <= n ; k++)
            for(int i = 1 ; i <= n ; i++)
                for(int j = 1 ; j <= n ; j++)
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        
        for(int i = 1 ; i <= n ; i++)
            for(int j = 1 ; j <= n ; j++)
                if(i != j && map[i][j] == max && map[j][i] == max)  check[i] = true;
    
        for(int i = 1 ; i <= n ; i++)
            if(!check[i])   answer++;
        
        return answer;
    }
}
