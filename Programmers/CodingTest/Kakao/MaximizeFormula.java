import java.util.List;
import java.util.ArrayList;

class MaximizeFormula {
    //숫자 리스트
    List<Long> numlist = new ArrayList<>();
    //연산자 리스트
    List<Character> oplist = new ArrayList<>();
    char[] ops = {'+', '-', '*'};
    boolean[] check = new boolean[3];
    long answer = 0;

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < expression.length() ; i++) {
            //숫자 저장
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                sb.append(expression.charAt(i));
            //연산자 저장
            else {
                numlist.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                oplist.add(expression.charAt(i));
            }
        }
        numlist.add(Long.parseLong(sb.toString()));
        
        dfs(new char[3], 0);
        return answer;
    }

    public void dfs(char[] prior, int depth) {
        if(depth == 3) {
            answer = Math.max(answer, Math.abs(startCalc(prior)));
            return;
        }

        //연산자 우선순위 계산
        for(int i = 0 ; i < 3 ; i++) {
            if(!check[i]) {
                check[i] = true;
                prior[depth] = ops[i];
                dfs(prior, depth+1);
                check[i] = false;
            }
        }
    }

    public long startCalc(char[] prior) {
        List<Long> cnum = new ArrayList<>(numlist);
        List<Character> cop = new ArrayList<>(oplist);
        long result;
        for(char c : prior) {
            int index = 0;
            while(index < cop.size()) {
                if(cop.get(index) == c) {
                    result = calc(cnum.get(index), cnum.get(index+1), c);
                    cnum.set(index, result);
                    cnum.remove(index+1);
                    cop.remove(index);
                }
                else    index++;
            }
        }
        return cnum.get(0);
    }

    public long calc(long a, long b, char op) {
        long result = 0;
        switch(op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
        }
        return result;
    }

}