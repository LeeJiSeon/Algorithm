import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class FindPrime {
    public static int solution(String numbers) {
        int answer = 0;
        String[] arrnum = numbers.split("");
        int[] check = new int[arrnum.length];
        List<String> prime = new ArrayList<>();
        HashSet hashset = new HashSet();

        for(int i = 0 ; i < arrnum.length ; i++){
            hashset.clear();
            hashset = Permutation(prime, arrnum, check, arrnum.length, i + 1, hashset);
            Iterator<String> it = hashset.iterator();
            while(it.hasNext())
                answer += isPrime(Integer.parseInt(it.next()));
        }
        return answer;
    }


    private static HashSet Permutation(List<String> prime, String[] arrnum, int[] check, int n, int c, HashSet hashset) {
        if(prime.size() == c){
            if(prime.get(0).equals("0"))
                return hashset;
            else{
                hashset.add(String.join("", prime));
                return hashset;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(check[i] == 0){
                check[i] = 1;
                prime.add(arrnum[i]);
                hashset = Permutation(prime, arrnum, check, n, c, hashset);
                prime.remove(prime.size() - 1);
                check[i] = 0;
            }
        }
        return hashset;
    }
 
    private static int isPrime(int num) {
        if(num == 1 || num == 0)
            return 0;
        if(num == 2)
            return 1;

        if(num % 2 == 0)
            return 0;
        else {
            for(int i = 3 ; i <= Math.sqrt(num) ; i = i + 2){
                if(num % i == 0)
                    return 0;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        String str = "011";
        System.out.println(solution(str));
    }
}