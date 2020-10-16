import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Sol17779 {
    static int N;
    static int[][] area;
    static int[] people;
    
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        area = new int[N+1][N+1];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++)
                area[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int d1 = 1 ; d1 < N-1 ; d1++) {
            for(int d2 = 1 ; d2 < N-d1 ; d2++) {
                for(int x = 1 ; x <= N-(d1+d2) ; x++) {
                    for(int y = d1+1 ; y <= N-d2 ; y++) {
                        int diff = divideArea(x, y, d1, d2);
                        min = Math.min(min, diff);       
                    }
                }
            }
        }
            
        System.out.println(min);
        br.close();
    }
    
    private static int divideArea(int x, int y, int d1, int d2) {
        people = new int[6];
        
        divideOne(x, y, d1, d2);
        divideTwo(x, y, d1, d2);
        divideThree(x, y, d1, d2);
        divideFour(x, y, d1, d2);
        divideFive(x, y, d1, d2);

        Arrays.sort(people);
               
        return people[5] - people[1];
    }
    
    private static void divideOne(int x, int y, int d1, int d2) {
        for(int r = 1 ; r < x ; r++) {
            for(int c = 1 ; c <= y ; c++) {
                people[1] += area[r][c];
            }
        }
        for(int r = x ; r < x+d1 ; r++) {
            for(int c = 1 ; c < y ; c++) {
                people[1] += area[r][c];
            }
            y--;
        }
    }
    
    private static void divideTwo(int x, int y, int d1, int d2) {
        for(int r = 1 ; r <= x ; r++) {
            for(int c = y+1 ; c <= N ; c++) {
                people[2] += area[r][c];
            }
        }
        for(int r = x+1 ; r <= x+d2 ; r++) {
            for(int c = y+2 ; c <= N ; c++) {
                people[2] += area[r][c];
            }
            y++;
        }
    }
    
    private static void divideThree(int x, int y, int d1, int d2) {
        for(int r = x+d1+d2+1 ; r <= N ; r++) {
            for(int c = 1 ; c < y-d1+d2 ; c++) {
                people[3] += area[r][c];
            }
        }
        for(int r = x+d1 ; r <= x+d1+d2 ; r++) {
            for(int c = 1 ; c < y-d1 ; c++) {
                people[3] += area[r][c];
            }
            y++;
        }
    }
    
    private static void divideFour(int x, int y, int d1, int d2) {
        for(int r = x+d1+d2+1 ; r <= N ; r++) {
            for(int c = y+d2-d1 ; c <= N ; c++) {
                people[4] += area[r][c];
            }
        }
        for(int r = x+d2+1 ; r <= x+d1+d2 ; r++) {
            for(int c = y+d2 ; c <= N ; c++) {
                people[4] += area[r][c];
            }
            y--;
        }
    }
    
    private static void divideFive(int x, int y, int d1, int d2) {
        int left = y, right = y, cnt1 = 0, cnt2 = 0;
        for(int r = x ; r <= x+d1+d2 ; r++) {
            for(int c = left ; c <= right ; c++)
                people[5] += area[r][c];
                
            if(cnt1 < d1)    left--;
            else    left++;
            
            if(cnt2 < d2)   right++;
            else    right--;
            
            cnt1++;     cnt2++;
        }
    }
}
