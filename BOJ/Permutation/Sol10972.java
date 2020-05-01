import java.util.Scanner;
class Sol10972 {
    static int[] per;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        per = new int[n];
        for(int i = 0 ; i < n ; i++)
            per[i] = sc.nextInt();
        boolean next = nextPermutation();
        if(!next)
            System.out.println(-1);
        else
            for(int i = 0 ; i < n ; i++)
                System.out.print(per[i] + " ");
        sc.close();
    }

    static boolean nextPermutation() {
        int i = n - 1;
        int j = n - 1;
        while(i > 0 && per[i-1] > per[i])   i--;

        if(i == 0)  return false;

        while(per[i-1] > per[j])    j--;
        swap(i-1, j);

        for(int k = n - 1 ; k > i ; k--)
            swap(i++, k);
        
        return true;
    }

    static void swap(int i, int j) {
        int tmp = per[i];
        per[i] = per[j];
        per[j] = tmp;
    }
}