package Programmers.KAKAO.카카오코드_예선_2017;

import java.util.*;

class 컬러링북_BFS {
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static boolean[][] visited;
    
    static int numberOfArea;
    static int maxSizeOfOneArea;
    
    static int m;
    static int n;
    
    public int bfs(int r, int c, int[][] picture) {
        int size = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        int target = picture[r][c];
        
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        size++;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

              if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                continue;
              }
                
                if (picture[nr][nc] == target && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    size++;
                }
            }
            
        }
        
        return size;
        
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        this.m = m;
        this.n = n;
        
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(bfs(i, j, picture)
                                                , maxSizeOfOneArea);
                    numberOfArea++;
                }
                System.out.print(picture[i][j] + " ");
            }
            System.out.println();
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}