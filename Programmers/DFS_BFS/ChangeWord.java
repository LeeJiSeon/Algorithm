class ChangeWord {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        for(int i = 0; i < words.length; i++) {
            boolean visited = new boolean[words.length];
            dfs(begin, words);
        }
        return answer;
    }

    static void dfs(String begin, String[] words) {
        for(int i = 0 ; i < words.length ; i++)
    }

}