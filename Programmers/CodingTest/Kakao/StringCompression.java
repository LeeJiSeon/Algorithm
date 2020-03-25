import java.util.Arrays;

class StringCompression {
    public static int solution(String s) {
        if(s.length() == 1)
            return 1;

        int min = s.length();
        
        for(int count = 1 ; count <= s.length() / 2 ; count++) {
            String str = "";
            String res = "";
            int c = 1;
            for(int index = 0 ; index < s.length() ; index += count) {
                if(index + count > s.length()) {
                    res += s.substring(index);
                    break;
                }

                if(str.equals(s.substring(index, index+count)))
                    c++;
                else {
                    if(c > 1)
                        res += Integer.toString(c);
                    c = 1;
                    str = s.substring(index, index+count);
                    res += s.substring(index, index+count);
                }
            }
            if(c > 1)
                res += Integer.toString(c);
            min = Math.min(min, res.length());
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }
}