import java.io.*;
class Sol1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0, count = 0;
        while(sum < s)
            sum += (++count);
        System.out.println(sum == s ? count : count-1);
    }
}
