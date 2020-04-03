import java.util.Stack;

class BaseBall {
    public int solution(int[][] baseball) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 1 ; i <= 9 ; i++)
            for(int j = 1 ; j <= 9 ; j++)
                for(int k = 1 ; k <= 9 ; k++)
                    if(i!=j && j!=k && k!=i)
                        stack.add(String.valueOf(i*100 + j*10 + k));
        
        while(!stack.isEmpty()) {
            String num = stack.pop();
            boolean flag = true;
            for(int i = 0 ; i < baseball.length ; i++) {
                int s = Strike(String.valueOf(baseball[i][0]), num);
                int b = Ball(String.valueOf(baseball[i][0]), num) - s;
                if(s != baseball[i][1] || b != baseball[i][2]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
    
    static int Strike(String base, String num) {
        int count = 0;
        for(int i = 0 ; i < 3 ; i++)
            if(base.charAt(i) == num.charAt(i))    count++;
        return count;
    }
    static int Ball(String base, String num) {
        int count = 0;
        for(int i = 0 ; i < 3 ; i++)
            if(num.contains(base.substring(i, i+1)))    count++;
        return count;
    }
}