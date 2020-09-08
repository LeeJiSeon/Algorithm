import java.util.*;
import java.text.SimpleDateFormat;

class Traffic {
    class log {
        private long startTime, endTime;
        
        log(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public int solution(String[] lines) throws Exception {
        int answer = 1;
        List<log> loglist = new ArrayList<>();
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        
        for(String line : lines) {
            String[] temp = line.split(" ");
	
			long end = format.parse(temp[1]).getTime();
			double sec = Double.parseDouble(temp[2].substring(0, temp[2].length()-1));
            long start = (long) (end - sec*1000 + 1);

            loglist.add(new log(start, end));
        }
        
        
        for(int i = 0 ; i < loglist.size() - 1 ; i++) {
            int max = 1;
            log nowlog = loglist.get(i);
            for(int j = i + 1 ; j < loglist.size() ; j++) {
                log nextlog = loglist.get(j);
                if(nextlog.startTime - 999 <= nowlog.endTime)
                    max++;
            }
            answer = Math.max(answer, max);
        }
        
        return answer;
    }
}
