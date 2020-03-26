class StrangeCountry_other {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        int[] num = {4, 1, 2};
        while(n > 0) {
            answer.append(num[n%3]);
            n = (n-1) / 3;
        }
        return answer.reverse().toString();
    }
}