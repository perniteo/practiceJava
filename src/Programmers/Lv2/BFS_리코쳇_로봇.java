package Programmers.Lv2;

import java.util.*;

class BFS_리코쳇_로봇 {

    // while -> 쭉 이동
    
    int[][] dist;
    boolean[][] graph;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int x;
    int y;
    
    int[] start = new int[2];
    int[] goal = new int[2];

    
    void bfs(int[] start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        dist[start[0]][start[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] n = q.poll();
            int cr = n[0];
            int cc = n[1];

          if (goal[0] == cr && goal[1] == cc) {
            return;
          }
            int cd = dist[cr][cc];
            
            for (int i = 0; i < 4; i++) {
                int nr = cr;
                int nc = cc;

                while (true) {
                    nr = nr + dr[i];
                    nc = nc + dc[i];
                    
                    if (nr < 0 || nc < 0 || nr >= x || nc >= y ||
                        !graph[nr][nc]) {
                        nr = nr - dr[i];
                        nc = nc - dc[i];
                        break;
                    } 
                }
                if (dist[nr][nc] == -1) {
                    q.offer(new int[]{nr, nc});
                    dist[nr][nc] = cd + 1;
                }
            }
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        x = board.length;
        y = board[0].length();
        
        dist = new int[x][y];
        graph = new boolean[x][y];
        
        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char c = board[i].charAt(j);
              if (c != 'D') {
                graph[i][j] = true;
              }
                if (c == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        bfs(start);
        
        return dist[goal[0]][goal[1]];
    }
}