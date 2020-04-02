class ChangeBracket {
    public String solution(String p) {
        return divide(p);
    }
    
    static String divide(String p) {
        if(p.equals(""))
            return "";
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int left = 0, right = 0, index = 0;
        while(left != right || (left == 0 && right == 0)) {
            if(p.charAt(index) == '(')
                left++;
            else if(p.charAt(index) == ')')
                right++;
            u.append(p.charAt(index));
            index++;
        }
        v.append(p.substring(index));
        if(u.charAt(0) == '(')
            return u.toString() + divide(v.toString());
        else {
            u.deleteCharAt(u.length()-1);
            u.deleteCharAt(0);
            for(int i = 0 ; i < u.length() ; i++)
                if(u.charAt(i) == '(')  u.setCharAt(i, ')');
                else    u.setCharAt(i, '(');
            return "(" + divide(v.toString()) + ")" + u.toString();
        }
    }
}