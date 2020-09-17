import java.util.*;
class Sol9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        int t = sc.nextInt();
        int[] arr = new int[t];
        int max = 0;
        
        for(int i = 0 ; i < 3 ; i++)
            list.add((long)1);
        for(int i = 0 ; i < 2 ; i++)
            list.add((long)2);
        for(int i = 0 ; i < t ; i++) {
            arr[i] = sc.nextInt() - 1;
            max = Math.max(arr[i], max);
        }
        
        for(int i = 5 ; i <= max ; i++)
            list.add(list.get(i-1) + list.get(i-5));
        for(int a : arr)
            System.out.println(list.get(a));
    }
}
