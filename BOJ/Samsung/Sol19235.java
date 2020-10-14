import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sol19235 {
    static int[][] green, blue;
    static int score;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int remain = 0;
        
        score = 0;
        green = new int[6][4];
        blue = new int[4][6];
        
        for(int a = 0 ; a < N ; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(t == 1) {
                int g = 5, b = 5;
                for(int i = 2 ; i < 6 ; i++)
                    if(green[i][y] > 0) {
                        g = i - 1;
                        break;
                    }
                for(int i = 2 ; i < 6 ; i++)
                    if(blue[x][i] > 0) {
                        b = i - 1;
                        break;
                    }
                green[g][y] = 1;
                blue[x][b] = 1;
                
            } else if(t == 2) {
                int g = 5, b = 5;
                for(int i = 2 ; i < 6 ; i++)
                    if(green[i][y] > 0 || green[i][y+1] > 0) {
                        g = i - 1;
                        break;
                    }
                for(int i = 2 ; i < 6 ; i++)
                    if(blue[x][i] > 0) {
                        b = i - 1;
                        break;
                    }
                green[g][y] = 2;    green[g][y+1] = 2;
                blue[x][b-1] = 1;    blue[x][b] = 1;
                
            } else if(t == 3) {
                int g = 5, b = 5;
                for(int i = 2 ; i < 6 ; i++)
                    if(green[i][y] > 0) {
                        g = i - 1;
                        break;
                    }
                for(int i = 2 ; i < 6 ; i++)
                    if(blue[x][i] > 0 || blue[x+1][i] > 0) {
                        b = i - 1;
                        break;
                    }
                green[g-1][y] = 1;    green[g][y] = 1;
                blue[x][b] = 2;     blue[x+1][b] = 2;
            }
            
            while(checkgreen())
                movegreen();
            checkweakgreen();
            
            while(checkblue())
                moveblue();
            checkweakblue();
        }

        System.out.println(score);
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++) {
                if(blue[i][j+2] > 0)
                    remain++;
                if(green[i+2][j] > 0)
                    remain++;
            }
        System.out.println(remain);

        br.close();
    }
    
    
    private static void checkweakgreen() {
        int cnt = 0;
        for(int i = 0 ; i < 2 ; i++)
            for(int j = 0 ; j < 4 ; j++) 
                if(green[i][j] > 0) {
                    cnt++;
                    break;
                }
        
        for(int i = 5-cnt ; i >= 2-cnt ; i--)
            for(int j = 0 ; j < 4 ; j++)
                green[i+cnt][j] = green[i][j];
        for(int i = 0 ; i < 2 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                green[i][j] = 0;
    }
    
    private static boolean checkgreen() {
        boolean isRemove = false;
        for(int i = 0 ; i < 6 ; i++) {
            boolean flag = true;
            for(int j = 0 ; j < 4 ; j++) {
                if(green[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                isRemove = true;
                score++;
                for(int j = 0 ; j < 4 ; j++)
                    green[i][j] = 0;
            }
        }
        return isRemove;
    }
    
    private static void movegreen() {
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (green[i][j] == 1) {
					int r = i;
					
					while (r + 1 < 6 && green[r + 1][j] == 0)   r++;
					
					if (r != i) {
						green[r][j] = green[i][j];
						green[i][j] = 0;
					}
				}
				else if (j < 3 && green[i][j] == 2 && green[i][j + 1] == 2) {
					int r = i;
					
					while (r + 1 < 6 && green[r + 1][j] == 0 && green[r + 1][j + 1] == 0)   r++;
					
					if (r != i) {
						green[r][j] = green[i][j];
						green[r][j + 1] = green[i][j + 1];
						green[i][j] = 0;
						green[i][j + 1] = 0;
					}
				}
			}
		}
    }
    
    private static void checkweakblue() {
        int cnt = 0;
        for(int j = 0 ; j < 2 ; j++)
            for(int i = 0 ; i < 4 ; i++)
                if(blue[i][j] > 0) {
                    cnt++;
                    break;
                }
        for(int j = 5-cnt ; j >= 2-cnt ; j--)
            for(int i = 0 ; i < 4 ; i++)
                blue[i][j+cnt] = blue[i][j];
        for(int j = 0 ; j < 2 ; j++)
            for(int i = 0 ; i < 4 ; i++)
                blue[i][j] = 0;
                
    }
    
    private static boolean checkblue() {
        boolean isRemove = false;
        for(int j = 0 ; j < 6 ; j++) {
            boolean flag = true;
            for(int i = 0 ; i < 4 ; i++) {
                if(blue[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                isRemove = true;
                score++;
                for(int i = 0 ; i < 4 ; i++)
                    blue[i][j] = 0;
            }
        }
        return isRemove;
    }
    
    private static void moveblue() {
        for (int j = 4; j >= 0; j--) {
			for (int i = 0; i < 4; i++) {
				if (blue[i][j] == 1) {
					int c = j;
					
					while (c + 1 < 6 && blue[i][c + 1] == 0) c++;
					
					if (c != j) {
						blue[i][c] = blue[i][j];
						blue[i][j] = 0;
					}
				}
				else if (i < 3 && blue[i][j] == 2 && blue[i + 1][j] == 2) {
					int c = j;
					
					while (c + 1 < 6 && blue[i][c + 1] == 0 && blue[i + 1][c + 1] == 0) c++;
					
					if (c != j) {
						blue[i][c] = blue[i][j];
						blue[i + 1][c] = blue[i + 1][j];
						blue[i][j] = 0;
						blue[i + 1][j] = 0;
					}
				}
			}
		}        
    }
}
