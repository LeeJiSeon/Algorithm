import java.util.*;
class NewsClutstering {
    public int solution(String str1, String str2) {
        String tmpstr = "";
        List<String> multiset1 = new ArrayList<>();
        List<String> multiset2 = new ArrayList<>();

        for(int i = 0 ; i < str1.length()-1 ; i++) {
            tmpstr = str1.substring(i, i+2).toLowerCase();
            if(tmpstr.matches("^[a-z]+$"))
                multiset1.add(tmpstr);
        }

        for(int i = 0 ; i < str2.length()-1 ; i++) {
            tmpstr = str2.substring(i, i+2).toLowerCase();
            if(tmpstr.matches("^[a-z]+$"))
                multiset2.add(tmpstr);
        }

        if(multiset1.isEmpty() && multiset2.isEmpty())
            return 65536;
        return getAnswer(multiset1, multiset2);
    }

    public int getAnswer(List<String> multiset1, List<String> multiset2) {
        int intersection = 0;
        int union = 0;
        for(String str : multiset1) {
            if(multiset2.contains(str)) {
                intersection++;
                multiset2.remove(str);
            }
            union++;
        }
        union += multiset2.size();
        return (int)((double)intersection/(double)union*65536);
    }
}