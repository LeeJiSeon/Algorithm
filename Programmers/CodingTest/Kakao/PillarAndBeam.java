import java.util.*;
class PillarAndBeam {
    static final int PILLAR = 0;
    static final int BEAM = 1;
    static final int DESTRUCT = 0;
    static final int CONSTRUCT = 1;
    
    boolean[][] pillars, beams;
    
    public int[][] solution(int n, int[][] build_frame) {     
        int count = 0;
        
        pillars = new boolean[n+3][n+3];
        beams = new boolean[n+3][n+3];
        
        for(int[] frame : build_frame) {
            int x = frame[1] + 1;
            int y = frame[0] + 1;
            int struct = frame[2];
            int command = frame[3];
            
            if(command == CONSTRUCT) {
                if(struct == PILLAR && canConstructPillar(x, y)) {
                    pillars[x][y] = true;
                    count++;
                } else if(struct == BEAM && canConstructBeam(x, y)) {
                    beams[x][y] = true;
                    count++;
                }
            } else if(command == DESTRUCT) {
                if(struct == PILLAR && canDestructPillar(x, y)) {
                    count--;
                } else if(struct == BEAM && canDestructBeam(x, y)) {
                    count--;
                }
            }
        }
        
        int index = 0;
        int[][] answer = new int[count][3];
        for(int i = 1 ; i <= n + 1 ; i++){
            for(int j = 1 ; j <= n + 1 ; j++){
                if(pillars[j][i]) answer[index++] = new int[]{i - 1, j - 1, PILLAR};
                if(beams[j][i]) answer[index++] = new int[]{i - 1, j - 1, BEAM};
            }
        }
        return answer;
    }
    
    private boolean canConstructPillar(int x, int y) {
        return x == 1 || beams[x][y] || beams[x][y-1] || pillars[x-1][y];
    }
    
    private boolean canConstructBeam(int x, int y) {
        return pillars[x-1][y] || pillars[x-1][y+1] || (beams[x][y-1] && beams[x][y+1]);
    }
    
    private boolean canDestructPillar(int x, int y) {
        pillars[x][y] = false;
        if((pillars[x+1][y] && !canConstructPillar(x+1,y)) || (beams[x+1][y] && !canConstructBeam(x+1, y))
          || (beams[x+1][y-1] && !canConstructBeam(x+1, y-1))) {
            pillars[x][y] = true;
            return false;
        }
        else    return true;
    }
    
    private boolean canDestructBeam(int x, int y) {
        beams[x][y] = false;
        if((pillars[x][y] && !canConstructPillar(x,y)) || (pillars[x][y+1] && !canConstructPillar(x,y+1))
          || (beams[x][y-1] && !canConstructBeam(x, y-1)) || (beams[x][y+1] && !canConstructBeam(x, y+1))) {
            beams[x][y] = true;
            return false;
        }
        else    return true;
    }
    
}
