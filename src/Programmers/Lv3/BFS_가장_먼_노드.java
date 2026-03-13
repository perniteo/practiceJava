package Programmers.Lv3;

import java.util.*;

class BFS_가장_먼_노드 {

    // level 단위
    
    ArrayList<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    
    int bfs(int start) {
        int result = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            result = q.size();
            
            for (int i = 0; i < result; i++) {
                int node = q.poll();
                
                for (int n : graph.get(node)) {
                    if (!visited[n]) {
                        q.offer(n);
                        visited[n] = true;
                    }
                }
            }
        }
        
        return result;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        visited = new boolean[n+1];
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        answer = bfs(1);
        
        return answer;
    }
}