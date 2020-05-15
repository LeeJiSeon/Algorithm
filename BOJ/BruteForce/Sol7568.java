import java.util.Scanner;
public class Sol7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] people = new int[n][2];
        int[] rank = new int[n];
        for(int i = 0 ; i < n ; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = i+1 ; j < n ; j++) {
                if(people[i][0] > people[j][0] && people[i][1] > people[j][1])
                    rank[j]++;
                else if(people[i][0] < people[j][0] && people[i][1] < people[j][1])
                    rank[i]++;
            }
            System.out.print(++rank[i] + " ");
        }
        
        sc.close();
    }
}