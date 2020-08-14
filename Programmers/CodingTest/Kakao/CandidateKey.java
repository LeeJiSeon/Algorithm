import java.util.*;
class CandidateKey {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        
        Set<String> selects = new HashSet<>();
        Set<Integer> candidates = new HashSet<>();
        
        for(int bitm = 1 ; bitm < (1 << colLen) ; bitm++) {
            selects.clear();
            for(int r  = 0 ; r < rowLen ; r++) {
                StringBuilder sb = new StringBuilder();
                for(int c = 0 ; c < colLen ; c++) {
                    if((bitm & (1 << c)) != 0) {
                        sb.append(relation[r][c]);
                        sb.append(",");
                    }
                }
                selects.add(sb.toString());
            }
            
            if(selects.size() == rowLen) {
                checkMinimum(bitm, candidates);
            }
        }
        return candidates.size();
    }
    
    public void checkMinimum(int bitm, Set<Integer> candidates) {
        for(int key : candidates) {
            if((bitm & key) == key)
                return;
        }
        candidates.add(bitm);
    }
}
