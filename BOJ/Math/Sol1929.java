import java.io.*;
class Sol1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        boolean[] eratos = new boolean[end + 1];
        eratos[1] = true;
        for(int i = 2 ; i <= Math.sqrt(end) ; i++) {
            for(int j = i * i ; j <= end ; j += i) {
                eratos[j] = true;
            }
        }
        for(int i = start ; i <= end ; i++) {
            if(!eratos[i])
                System.out.println(i);
        }
    }
}
