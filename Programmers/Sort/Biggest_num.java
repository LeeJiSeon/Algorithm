import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

class Biggest_num {
    public static String solution(int[] numbers) {

        String[] num = new String[numbers.length];

        for(int i = 0 ; i < num.length ; i++)
            num[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2.concat(o1)).compareTo(o1.concat(o2));
            }
        });

        if(num[0].startsWith("0")){
            return "0";
        }
        else{
            return String.join("", num);
        }

    }

    public static void main(String[] args) {
        int[] numbers = {0};
        System.out.println(solution(numbers));
    }
}