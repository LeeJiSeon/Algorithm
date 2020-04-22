import java.util.*;
class Sol6603 {
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while(true) {
            int n = sc.nextInt();
            if(n == 0)
                break;
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
                arr[i] = sc.nextInt();
            list.add(arr);
        }

        for(int[] l : list) {
            findNum(l);
            System.out.println();
        }
    }

    static void findNum(int[] lotto) {
        list = new ArrayList<>();
        dfs(0, 0, lotto);
    }

    static void dfs(int start, int index, int[] lotto) {
        if(index == 6) {
            printNum(list);
            return;
        }
        for(int i = start ; i < lotto.length ; i++) {
            list.add(lotto[i]);
            dfs(i+1, index+1, lotto);
            list.remove(list.size() - 1);
        }
    }

    static void printNum(List<Integer> list) {
        for(int i = 0 ; i < list.size() ; i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}