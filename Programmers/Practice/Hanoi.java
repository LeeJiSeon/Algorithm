import java.util.*;
class Hanoi {
    List<int[]> result;
    public int[][] solution(int n) {
        result = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[result.size()][2];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i][0] = result.get(i)[0];
            answer[i][1] = result.get(i)[1];
        }
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};
        if(n == 1)
            result.add(move);
        else {
            hanoi(n-1, from, via, to);
            result.add(move);
            hanoi(n-1, via, to, from);
        }        
    }
}
