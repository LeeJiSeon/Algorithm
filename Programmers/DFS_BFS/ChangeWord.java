import java.util.*;
class ChangeWord {
    boolean[] visited;
    String target = "";
    int min = 100;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        this.target = target;
        dfs(begin, words, 0);
        return min == 100 ? 0 : min;
    }

    private void dfs(String begin, String[] words, int count) {
        for(int i = 0 ; i < words.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(checkWord(begin, words[i])) {
                    if(words[i].equals(target))
                        min = Math.min(min, count + 1);
                    else
                        dfs(words[i], words, count + 1);
                }
                visited[i] = false;
            }
        }
    }

    private boolean checkWord(String begin, String target) {
        int count = 0;
        for(int i = 0; i < begin.length() ; i++)
            if(begin.charAt(i) != target.charAt(i))
                count++;
        if(count == 1)  return true;
        return false;
    }
}