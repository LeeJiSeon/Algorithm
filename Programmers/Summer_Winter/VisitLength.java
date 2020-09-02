class Solution {
    class Point {
        boolean u, d, l, r;
    }
    
    public int VisitLength(String dirs) {
        int answer = 0;
        Point[][] matrix = new Point[11][11];
        int x = 5, y = 5;
        for(int i = 0 ; i < 11; i ++)
            for(int j = 0 ; j < 11; j++)
                matrix[i][j] = new Point();
        for(int i = 0 ; i < dirs.length() ; i++) {
            if(dirs.charAt(i) == 'U') {
                if(x == 0)
                    continue;
                if(!matrix[x][y].u) {
                    matrix[x][y].u = true;
                    matrix[x-1][y].d = true;
                    answer++;   
                }
                x--;
            }
            else if(dirs.charAt(i) == 'D') {
                if(x == 10)
                    continue;
                if(!matrix[x][y].d) {
                    matrix[x][y].d = true;
                    matrix[x+1][y].u = true;
                    answer++;   
                }
                x++;
            }
            else if(dirs.charAt(i) == 'L') {
                if(y == 0)
                    continue;
                if(!matrix[x][y].l) {
                    matrix[x][y].l = true;
                    matrix[x][y-1].r = true;
                    answer++;   
                }
                y--;
            }
            else if(dirs.charAt(i) == 'R') {
                if(y == 10)
                    continue;
                if(!matrix[x][y].r) {
                    matrix[x][y].r = true;
                    matrix[x][y+1].l = true;
                    answer++;   
                }
                y++;
            }
        }
        return answer;
    }
}
