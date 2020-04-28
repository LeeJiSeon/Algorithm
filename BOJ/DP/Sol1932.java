import java.util.Scanner;
class Sol1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tri = new int[n][];
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            tri[i] = new int[i+1];
            for(int j = 0 ; j < tri[i].length ; j++)
                tri[i][j] = sc.nextInt();
        }

        for(int i = 1 ; i < n ; i++)
            for(int j = 0 ; j < tri[i].length ; j++) {
                if(j == 0)
                    tri[i][j] += tri[i-1][j];
                else if(j == tri[i].length - 1)
                    tri[i][j] += tri[i-1][j-1];
                else
                    tri[i][j] += Math.max(tri[i-1][j-1], tri[i-1][j]);

                if(i == n-1)
                    max = Math.max(max, tri[i][j]);
            }
        System.out.println(max);
        sc.close();
    }
}