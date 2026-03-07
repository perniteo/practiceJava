package Programmers.KAKAO.BLIND2019;

import java.util.*;

class BF_후보키 {

    // 비트마스킹이 최적
    // 완전 탐색 + 조합
    
    ArrayList<String> pick = new ArrayList<>();
    
    StringBuilder sb = new StringBuilder();
    
    void dfs(int depth, int size) {
        if (sb.length() == size) {
            return;
        }
        
        for (int i = depth; i < size; i++) {
            sb.append(i);
            pick.add(sb.toString());
            dfs(i + 1, size);
            sb.setLength(sb.length() - 1);
        }
        
    }
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>(); 
        
        dfs(0, relation[0].length);
        
        Collections.sort(pick, (a, b) -> {
            return a.length() - b.length();
        });
        
        for (String p : pick) {
            
            Set<String> set = new HashSet<>();
            
            char[] chars = p.toCharArray();
            
            for (int i = 0; i < relation.length; i++) {
                sb = new StringBuilder();
                for (char c : chars) {
                    sb.append(relation[i][Integer.valueOf(c - '0')]);
                }
                set.add(sb.toString());
            }
            
            if (set.size() == relation.length) {
                boolean add = true;
                 if (list.size() > 0) {
                     for (String s : list) {
                         boolean subset = true;

                         for (char c : s.toCharArray()) {
                             if (p.indexOf(c) == -1) {
                                 subset = false;
                                 break;
                             }
                         }
                         if (subset) {
                             add = false;
                             break;
                         }
                     }
                 }
              if (add) {
                list.add(p);
              }
            }
            
        }
        
        answer = list.size();
        
        return answer;
    }
}