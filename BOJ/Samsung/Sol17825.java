import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Sol17825 {
    static int max = 0;
    static Horse[] horse;
    static Map<String, int[]> map;
    static int[] numbers;
    static boolean[] isFinish;
    
    private static void makeMap() {
        int[] zero = new int[21];
        for(int i = 0 ; i < 21 ; i++)
            zero[i] = i * 2;

        int[] ten = {10, 13, 16, 19, 25, 30, 35, 40};
        int[] twenty = {20, 22, 24, 25, 30, 35, 40};
        int[] thirty = {30, 28, 27, 26, 25, 30, 35, 40};
        
        map.put("zero", zero);
        map.put("ten", ten);
        map.put("twenty", twenty);
        map.put("thirty", thirty);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //input
        map = new HashMap<>();
        horse = new Horse[4];
        isFinish = new boolean[4];
        makeMap();
        for(int i = 0 ; i < 4 ; i++)
            horse[i] = new Horse("zero", 0);
            
        numbers = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 10 ; i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        
        
        //solve problem
        dfs(0, 0);
        System.out.println(max);
        
        br.close();
    }
    
    private static void dfs(int depth, int score) {
        if(depth == 10) {
            max = Math.max(score, max); 
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++) {
            if(isFinish[i])
                continue;
            Horse h = horse[i];
            String pre_name = h.mapname;
            int pre_pos = h.pos;
            int now_score = 0;
            
            h.pos += numbers[depth];
            
            if(h.mapname.equals("zero")) {
                if(h.pos == 5) {
                    h.mapname = "ten";
                    h.pos = 0;
                } else if(h.pos == 10) {
                    h.mapname = "twenty";
                    h.pos = 0;
                } else if(h.pos == 15) {
                    h.mapname = "thirty";
                    h.pos = 0;
                }
            }
            
            //같은 위치인 경우
            if(h.pos < map.get(h.mapname).length && samePosition(i)) {
                h.mapname = pre_name;
                h.pos = pre_pos;
                continue;
            }
            
            if(h.pos >= map.get(h.mapname).length) //도착한 경우
                isFinish[i] = true;
            else    now_score = map.get(h.mapname)[h.pos];
            
            dfs(depth + 1, score + now_score);
            
            isFinish[i] = false;
            h.mapname = pre_name;
            h.pos = pre_pos;
        }
    }
    
    private static boolean samePosition(int idx) {
        Horse h1 = horse[idx];
        for(int i = 0 ; i < 4 ; i++) {
            Horse h2 = horse[i];
            if(idx == i || isFinish[i])
                continue;
            if(h1.mapname.equals(h2.mapname) && h1.pos == h2.pos)
                return true;
            if(map.get(h1.mapname)[h1.pos] == 40 && map.get(h2.mapname)[h2.pos] == 40)
                return true;
            if(!h1.mapname.equals("zero") && !h2.mapname.equals("zero")) {
                if(h1.pos > 0 && h2.pos > 0 && map.get(h1.mapname)[h1.pos] == map.get(h2.mapname)[h2.pos])
                    return true;
            }
        }
        return false;
    }
}

class Horse {
    String mapname;
    int pos;
    
    Horse(String mapname, int pos) {
        this.mapname = mapname;
        this.pos = pos;
    }
}
