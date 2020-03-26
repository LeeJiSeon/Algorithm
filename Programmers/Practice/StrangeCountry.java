class StrangeCountry {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        int[] num = {1, 2, 4};
        int q = n;
        while(true) {
            if(q % 3 == 0) {
                answer.append(String.valueOf(num[2]));
                q = q / 3 - 1;
            }
            else {
                answer.append(String.valueOf(num[q%3-1]));
                q /= 3;
            }
            if(q == 0)
                break;
        }
        return answer.reverse().toString();
    }
}