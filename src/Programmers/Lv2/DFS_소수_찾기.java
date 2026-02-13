package Programmers.Lv2;

import java.util.*;

class DFS_소수_찾기 {

    // 완전 탐색, DFS, back-tracking, 순열
    Set<Integer> pSet = new HashSet<>();
    
    final int max = 10_000_000;
    
    boolean[] prime = new boolean[max];
    
    int nLen;
    
    char[] cArr;
    
    void dfs(boolean[] use, StringBuilder sb) {
        if (!sb.isEmpty()) {
            int n = Integer.parseInt(sb.toString());
            if (!prime[n]) {
                pSet.add(n);
            }
        }
        
        for (int i = 0; i < nLen; i++) {
            if (!use[i]) {
                char c = cArr[i];
                sb.append(c);
                use[i] = true;
                dfs(use, sb);
                sb.setLength(sb.length() - 1);
                use[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        nLen = numbers.length();
        
        prime[0] = true;
        prime[1] = true;
        
        for (int i = 2; i < Math.sqrt(max); i++) {
            for (int j = i * i; j < max; j += i) {
                prime[j] = true;
            }
        }
        
        cArr = numbers.toCharArray();
        
        dfs(new boolean[nLen], new StringBuilder());
        
        answer = pSet.size();
        
        return answer;
    }
}