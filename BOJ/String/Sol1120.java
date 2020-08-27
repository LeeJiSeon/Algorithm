import java.io.*;
class Sol1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        String A = str[0];
        String B = str[1];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= B.length() - A.length() ; i++) {
            int sum = 0;
            for(int j = 0 ; j < A.length() ; j++) {
                if(A.charAt(j) != B.charAt(i+j))
                    sum++;
            }
            min = Math.min(min, sum);
        }
        System.out.println(min); 
    }
}
