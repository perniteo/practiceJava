package Programmers.KAKAO.BLIND2021;

import java.util.*;

class Impl_메뉴_리뉴얼 {

  // 구현
    
    Map<String, Integer> map = new HashMap<>();
    
    void dfs(String order, StringBuilder sb, int c, int idx) {
        if (sb.length() == c) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

      if (idx >= order.length()) {
        return;
      }
        
        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(order, sb, c, i + 1);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            for (int j = 0; j < course.length; j++) {
                dfs(sorted, new StringBuilder(), course[j], 0);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        
        int[] maxCourse = new int[11];
        
        for (String k : map.keySet()) {
          if (map.get(k) < 2) {
            continue;
          }
            maxCourse[k.length()] = 
                Math.max(maxCourse[k.length()], map.get(k));
        }
        
        for (String k : map.keySet()) {
          if (maxCourse[k.length()] == map.get(k)) {
            list.add(k);
          }
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}