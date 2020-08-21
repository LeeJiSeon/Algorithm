import java.util.*;
class TravelRoute {
    class Dest {
        String dest;
        int index;
        Dest(String dest, int index) {
            this.dest = dest;
            this.index = index;
        }
    }
    
    boolean[] visit;
    Map<String, List<Dest>> ticketMap;
    List<String> routelist;
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        ticketMap = new HashMap<>();
        routelist = new ArrayList<>();
        
        for(int i = 0 ; i < tickets.length ; i++) {
            List<Dest> list = ticketMap.getOrDefault(tickets[i][0], new ArrayList<>());
            list.add(new Dest(tickets[i][1], i));
            ticketMap.put(tickets[i][0], list);
        }
        
        dfs("ICN", new StringBuffer(), 0);
        
        Collections.sort(routelist);
        return routelist.get(0).split(",");
    }
    
    private void dfs(String start, StringBuffer route, int count) {
        route.append(start);
        route.append(",");
        
        if(count == visit.length) {
            routelist.add(route.toString());   
            return;
        }
        if(!ticketMap.containsKey(start))
            return;
        for(Dest list : ticketMap.get(start)) {
            if(!visit[list.index]) {
                visit[list.index] = true;
                dfs(list.dest, route, count+1);
                route.delete(route.length()-4, route.length());
                visit[list.index] = false;
            }
        }
    }
}
