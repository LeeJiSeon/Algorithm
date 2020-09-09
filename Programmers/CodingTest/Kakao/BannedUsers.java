import java.util.*;
class BannedUsers {
    Set<Set<String>> idSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        idSet = new HashSet<>();
        //LinkedHashSet : 순서를 갖는 집합
        dfs(user_id, banned_id, new LinkedHashSet<>());        
        return idSet.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, Set<String> idlist) {
        if(idlist.size() == banned_id.length) {
            if(isBannedUser(banned_id, idlist))
                idSet.add(new HashSet<>(idlist));
            return;
        }
        
        for(String user : user_id) {
            if(!idlist.contains(user)) {
                idlist.add(user);
                dfs(user_id, banned_id, idlist);
                idlist.remove(user);
            }
        }
    }
    
    private boolean isBannedUser(String[] banned_id, Set<String> idlist) {
        int index = 0;
        for(String id : idlist) {
            String ban = banned_id[index++];
            if(ban.length() != id.length())
                return false;
            for(int j = 0 ; j < ban.length() ; j++) {
                if(ban.charAt(j) == '*')
                    continue;
                if(ban.charAt(j) != id.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
