package Programmers.Lv3;

import java.util.*;

class BFS_단어_변환 {
    
    boolean[] visited;
    
    int bfs(String b, String t, String[] words) {

        int result = 0;
        
        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer(b);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();

              if (w.equals(t)) {
                return result;
              }
                
                for (int j = 0; j < words.length; j++) {
                  if (visited[j]) {
                    continue;
                  }
                    
                    String word = words[j];
                    int cnt = 0;
                    for (int k = 0; k < word.length(); k++) {
                      if (w.charAt(k) != word.charAt(k)) {
                        cnt++;
                      }
                      if (cnt > 1) {
                        break;
                      }
                    }
                    if (cnt == 1) {
                        q.offer(word);
                        visited[j] = true;
                    }
                }
            }
            result++;
        }
        return 0;
        
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        int r = bfs(begin, target, words);
        
        return r;
    }
}