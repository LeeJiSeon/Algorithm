import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sol14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[2 * N][N];
        int cnt = 0;
        
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                map[j + N][i] = height;
            }
        }
        
        for(int i = 0 ; i < 2 * N ; i++) {
            boolean canPass = true;
            int height = map[i][0];
            int idx = 1, cont = 1;
            while(idx < N) {
                if(height == map[i][idx]) {
                    idx++;
                    cont++;
                } else if(height - map[i][idx] == 1) {
                    height = map[i][idx];
                    cont = 1;
                    idx++;
                    while(idx < N && map[i][idx] == height) {
                        cont++;
                        idx++;
                    }
                    if(cont < L) {
                        canPass = false;
                        break;
                    }
                    cont = cont - L;
                } else if(map[i][idx] - height == 1) {
                    if(cont < L) {
                        canPass = false;
                        break;
                    }
                    height = map[i][idx];
                    cont = 1;
                    idx++;
                } else {
                    canPass = false;
                    break;
                }
            }
            
            if(canPass) cnt++;
        }
        
        System.out.println(cnt);
    }
}
