import java.util.*;
class TheSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = removeSharp(m);
        int maxlen = 0;
        
        for(String music : musicinfos) {
            music = removeSharp(music);
            String[] info = music.split(",");
            StringBuilder sb = new StringBuilder();
            
            int playtime = (Integer.parseInt(info[1].split(":")[0])*60 + Integer.parseInt(info[1].split(":")[1])) - (Integer.parseInt(info[0].split(":")[0])*60 + Integer.parseInt(info[0].split(":")[1]));
            
            for(int i = 0 ; i < playtime ; i++) {
                sb.append(info[3].charAt(i % info[3].length()));
            }
            
            if(sb.toString().contains(m)) {
                if(playtime > maxlen) {
                    answer = info[2];
                    maxlen = playtime;
                }
            }
            
        }
        
        return answer;
    }
    
    private String removeSharp(String m) {
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        return m;
    }
}
