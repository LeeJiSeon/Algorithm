import java.io.*;
class Sol11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++) {
            String[] command = br.readLine().split(" ");
            int n = 0;
            if(command[0].equals("add")) {
                n = Integer.parseInt(command[1]) - 1;
                result |= (1 << n);
            }
            else if(command[0].equals("remove")) {
                n = Integer.parseInt(command[1]) - 1;
                result -= (1 << n);
            }
            else if(command[0].equals("check")) {
                n = Integer.parseInt(command[1]) - 1;
                if((result & (1 << n)) > 0)    sb.append("1\n");
                else    sb.append("0\n");
            }
            else if(command[0].equals("toggle")) {
                n = Integer.parseInt(command[1]) - 1;
                result ^= (1 << n);
            }
            else if(command[0].equals("all"))
                result = (1 << 20) - 1;
            else if(command[0].equals("empty"))
                result = 0;          
        }
        System.out.println(sb.toString());
    } 
}
