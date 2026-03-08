package Programmers.Lv3;

import java.util.*;

class DFS_네트워크 {

    // graph를 사용하지 않고 바로 가능
    
    ArrayList<List<Integer>> graph = new ArrayList<>();
    
    boolean[] visited;
    
    void dfs(int index) {
        List<Integer> list = graph.get(index);
        
        for (int n : list) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            int[] computer = computers[i];
            for (int j = 0; j < n; j++) {
                if (computer[j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}