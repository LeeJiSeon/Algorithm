class RightBracket {
    boolean solution(String s) {
        int left = 0, right = 0;

        for(int i = 0; i < s.length(); i++) {
            if(right > left)
                return false;
            if(s.charAt(i) == '(')  left++;
            else    right++;
        }
        if(left != right)
            return false;

        return true;
    }
}