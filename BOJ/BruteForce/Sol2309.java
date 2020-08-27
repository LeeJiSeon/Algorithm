import java.io.*;
import java.util.Arrays;
class Sol2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dw = new int[9];
        int height = 0;
        for(int i = 0 ; i < dw.length ; i++) {
            dw[i] = Integer.parseInt(br.readLine());
            height += dw[i];
        }
        Arrays.sort(dw);
        for(int i = 0 ; i < dw.length-1 ; i++)
            for(int j = i+1 ; j < dw.length ; j++) {
                if(height - dw[i] - dw[j] == 100) {
                    for(int k = 0 ; k < dw.length ; k++) {
                        if(k != i && k != j)
                            System.out.println(dw[k]);
                    }
                    return;
                }
            }
    }
}
