class Change {
    static final int mod = 1000000007;
    
    public int solution(int n, int[] money) {
        int[] answer = new int[n+1];
        answer[0] = 1;
        for(int i : money) {
            for(int j = i ; j <= n ; j++) {
                answer[j] += answer[j - i];
                answer[j] %= mod;
            }
        }        
        return answer[n];
    }
}
