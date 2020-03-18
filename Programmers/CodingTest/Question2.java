//Line
import java.util.*;

class Question2 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int k = sc.nextInt();
        String[] output = new String[input.length];
        boolean[] checked = new boolean[input.length];
        
        Permutation(input, output, checked, input.length, input.length, 0);
        Collections.sort(list);
        System.out.println(list.get(k - 1));
    }

    private static void Permutation(String[] input, String[] output, boolean[] checked, int n, int r, int depth) {
        if(depth == r) {
            list.add(String.join("", output));
        }
        for(int i = 0 ; i < input.length ; i++) {
            if(!checked[i]){
                checked[i] = true;
                output[depth] = input[i];
                Permutation(input, output, checked, n, r, depth + 1);
                checked[i] = false;
            }
        }
    }
}