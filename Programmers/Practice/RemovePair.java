import java.util.Stack;

class RemovePair {
    public int solution(String s)
    {
        if(s.length() == 1)
            return 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(st.isEmpty()) {
                st.add(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i))
                st.pop();
            else    st.add(s.charAt(i));
        }

        if(st.isEmpty())    return 1;
        else    return 0;
    }
}