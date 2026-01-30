package Programmers.코드챌린지_2025;

import java.util.*;

class 지게차와_크레인_1차예선 {

    // 개인적 고찰입니다.

    // refactoring 보다는 문제 구현에 집중해서 내가 생각한 방향이 맞는지 검증하고 싶었음
    // 결과적으로는 맞았고 이러한 방식을 외부 BFS 라고 한다고 함
    // 다만 혼자 사고해서 나온 방식이라 이렇게 하면 가능할 것 같다고 생각하면서도
    // 다른 더 효율적인 방법이 있지 않을까 스스로를 의심하게 됨
    // 그래서 구현에 집중하고 검증했음
    // 또한 헷갈렸던 것 중 하나는 String 배열로 주어지는 requests들이 greedy한 풀이를 생각하게 됨
    // 그러나 각 rq를 level단위로 처리해야 하겠다고 생각해서 bfs로 정하고 graph로 바꿈
    
    static int answer;
    
    static char[][] graph;
    
    static boolean[][] visited;
    
    static int n;
    static int m;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static ArrayList<int[]> bfs(String request) {
        visited = new boolean[n+2][m+2];
        
        ArrayList<int[]> list = new ArrayList<>();
        
        char target = request.charAt(0);
        
        if (request.length() > 1) {
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < m + 2; j++) {
                    if (graph[i][j] == target) {
                        list.add(new int[]{i, j});
                        answer--;
                    }
                }
            }
            return list;
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] next = q.poll();
            int cr = next[0];
            int cc = next[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

              if (nr < 0 || nc < 0 || nr >= n + 2 || nc >= m + 2) {
                continue;
              }
                
                if (graph[nr][nc] == '0' && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
                if (graph[nr][nc] == target && !visited[nr][nc]) {
                    list.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    answer--;
                }
            }
        }
        return list;
    }
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        answer = n * m;
        
        graph = new char[n+2][m+2];
        
        for (char[] cs : graph) {
            Arrays.fill(cs, '0');
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for (String rq : requests) {
            for (int[] num : bfs(rq)) {
                graph[num[0]][num[1]] = '0';
            }
        }
        
        return answer;
    }
}