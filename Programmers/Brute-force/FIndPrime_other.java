import java.util.*;

class FindPrime_other {
    public static int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> hashset = new HashSet();
        Permutation("", numbers, hashset);
        Iterator<Integer> it = hashset.iterator();
        while(it.hasNext()){
            int num = it.next();
            if(num == 2)
                answer++;
            else if(num % 2 != 0)
                answer += isPrime(num);
        }

        return answer;
    }

    private static void Permutation(String prefix, String numbers, HashSet<Integer> hashset) {
        int len = numbers.length();
        if(!prefix.equals(""))
            hashset.add(Integer.valueOf(prefix));
        for(int i = 0 ; i < len ; i++){
            Permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1, len), hashset);
        }
    }
 
    private static int isPrime(int num) {
        if(num == 1 || num == 0)
            return 0;

        for(int i = 3 ; i <= Math.sqrt(num) ; i = i + 2){
            if(num % i == 0)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        String str = "011";
        System.out.println(solution(str));
    }
}