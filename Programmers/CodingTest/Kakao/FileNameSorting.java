import java.util.*;
class FileNameSorting {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
                //음수or0이면 유지, 양수이면 자리교환
                @Override
                public int compare(String s1, String s2) {
                    String h1 = s1.split("[0-9]")[0];
                    String h2 = s2.split("[0-9]")[0];
                    
                    int result = h1.toLowerCase().compareTo(h2.toLowerCase());
                    if(result == 0) {
                        result = findNum(s1, h1) - findNum(s2, h2);
                    }
                    return result;
                }
            }
        );
        return files;
    }
    
    public int findNum(String file, String head) {
        file = file.replace(head, "");
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while(index < file.length() && Character.isDigit(file.charAt(index))) {
            sb.append(file.charAt(index));
            index++;
        }
        return Integer.valueOf(sb.toString());
    }
}
