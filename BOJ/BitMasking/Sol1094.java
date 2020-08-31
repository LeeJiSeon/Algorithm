import java.io.*;
class Sol1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = 64;
        int sum = 64;
        while(sum != x) {
            n /= 2;
            if(sum - n >= x)    sum -= n;
        }
        System.out.println(Integer.bitCount(sum));
    }
}
