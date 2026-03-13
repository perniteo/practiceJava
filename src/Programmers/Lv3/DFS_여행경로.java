package Programmers.Lv3;

import java.util.*;

class DFS_여행경로 {
    
    Map<String, List<String>> map = new HashMap<>();
    
    List<String> path = new ArrayList<>();
    
    int target;
    
    boolean dfs(String start, int count) {
      if (count == target) {
        return true;
      }
        
        List<String> dest = map.get(start);

      if (dest == null) {
        return false;
      }
        
        if (dest.size() > 1) {
            Collections.sort(dest);
        }
        
        for (int i = 0; i < dest.size(); i++) {
            String next = dest.get(i);
            
            dest.remove(next);
            path.add(next);

          if (dfs(next, count + 1)) {
            return true;
          }
            
            dest.add(i, next);
            path.remove(path.size() - 1);
        }
        
        return false;
    }
    
    public String[] solution(String[][] tickets) {
        target = tickets.length + 1;
        
        String[] answer = new String[target];
        
        for (String[] ticket : tickets) {
            List<String> dest = map.getOrDefault(ticket[0], new ArrayList<>());
            dest.add(ticket[1]);
            map.put(ticket[0], dest);
        }
        
        path.add("ICN");
        dfs("ICN", 1);
        
        for (int i = 0; i < target; i++) {
            answer[i] = path.get(i);
        }
        
        return answer;
    }
}