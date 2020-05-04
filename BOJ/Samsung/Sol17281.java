import java.util.*;
public class Sol17281 {
    static int n;
    static int[][] result;
    static int[] np, seq;
    static int field, max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seq = new int[9];
        np = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        result = new int[n][9];
        max = 0;
        for(int i  = 0 ; i < n ; i++)
            for(int j = 0 ; j < 9 ; j++)
                result[i][j] = sc.nextInt();

        do {
            for(int i = 0 ; i < 3 ; i++)
                seq[i] = np[i];
            for(int i = 4 ; i < 9 ; i++)
                seq[i] = np[i-1];
            max = Math.max(max, score());
        } while(nextPermutation());

        System.out.println(max);
        sc.close();
    }

    static int score() {
        int player = 0;
        int sum = 0;
        for(int inning = 0 ; inning < n ; inning++) {
            int out = 0;
            field = 0;
            while(out < 3) {
                if(result[inning][seq[player]] == 0)    out++;
                else    sum += move(result[inning][seq[player]]);
                player = (player + 1) % 9;
            }
        }
        return sum;
    }

    static int move(int player) {
        int sum = 0;
        if(player == 1) {
            sum += Integer.bitCount(field & 0b10);
            field = (field >>> 1) & 0b1110;
            field += 0b1000;
        }
        else if(player == 2) {
            sum += Integer.bitCount(field & 0b110);
            field = (field >>> 2) & 0b1110;
            field += 0b0100;
        }
        else if(player == 3) {
            sum += Integer.bitCount(field & 0b1110);
            field = (field >>> 3) & 0b1110;
            field += 0b0010;
        }
        else if(player == 4) {
            sum += (Integer.bitCount(field) + 1);
            field = 0;
        }
        return sum;
    }

    static boolean nextPermutation() {
        int i = 7;
        int j = 7;

        while(i > 0 && np[i-1] > np[i]) i--;
        if(i == 0)  return false;
        
        while(np[i-1] > np[j]) j--;
        swap(i-1, j);

        for(int k = 7 ; k > i ; k--)
            swap(i++, k);
        return true;
    }

    static void swap(int i, int j) {
        int tmp = np[i];
        np[i] = np[j];
        np[j] = tmp;
    }
}