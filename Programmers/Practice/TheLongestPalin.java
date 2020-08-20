class TheLongestPalin
{
    public int solution(String s)
    {
        int answer = 1;       
        
        for(int index = 0 ; index < s.length() ; index++) {
            int left, right;
            int len = 0;
            if(index > 0 && index < s.length()-1 && s.charAt(index-1) == s.charAt(index+1)) {
                left = index - 1;
                right = index + 1;
                len = 1;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    len += 2;
                }
                answer = Math.max(answer, len);
            }
            if(index < s.length()-1 && s.charAt(index) == s.charAt(index+1)) {
                left = index - 1;
                right = index + 2;
                len = 2;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    len += 2;
                }
                answer = Math.max(answer, len);
            }
        }
        return answer;
    }
}
