class Tile {
    public long solution(int N) {
        long[] answer = new long[N+2];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2 ; i < N+2 ; i++) {
            answer[i] = answer[i-1] + answer[i-2];
        }
        return answer[N+1] * 2;
    }
}