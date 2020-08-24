import java.util.*;

class ExpressionOfN {
    public int solution(int N, int number) {
        if(N == number)
            return 1;
        
        int answer = -1;
        List<Set<Integer>> expression = new ArrayList<>();
        expression.add(new HashSet<>(Arrays.asList(N)));
        int suc = N;
        
        for(int i = 1 ; i < 8 ; i++) {
            Set<Integer> cur = new HashSet<>();
            suc += Math.pow(10, i)*N;
            cur.add(suc);
            for(int left = 0 ; left < i ; left++) {
                int right = i - left - 1;
                for(int num1 : expression.get(left))
                    for(int num2 : expression.get(right)) {
                        cur.add(num1 + num2);
                        cur.add(num1 - num2);
                        cur.add(num1 * num2);
                        if(num2 != 0)   cur.add(num1 / num2);
                    }
            }
            
            if(cur.contains(number)) {
                answer = i + 1;
                break;
            }
            expression.add(cur);
        }
        return answer;
    }
}
