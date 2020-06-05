class JadenCase {
    public String solution(String s) {
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for(int i  = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(flag) {
                sb.append(Character.toUpperCase(c));
                flag = false;
            } 
            else
                sb.append(Character.toLowerCase(c));
            if(c == ' ')
                flag = true;
        }
        return sb.toString();
    }
}