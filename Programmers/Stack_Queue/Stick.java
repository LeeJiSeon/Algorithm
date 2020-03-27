class Stick {
    public int solution(String arrangement) {
        int answer = 0;
        int count = 0;
        for(int i = 0 ; i < arrangement.length() ; i++) {
            if(arrangement.charAt(i) == '(') {
                if(arrangement.charAt(i+1) == ')') {
                    answer += count;
                    i++; 
                }
                else    count++;
            }
            else {
                count--;
                answer++;
            }
        }
        return answer;
    }
}