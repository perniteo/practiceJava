package Programmers.KAKAO.인턴십2021;

class Graph_거리두기_확인하기 {
    
    // false
    int[] dr1 = {-1, 1, 0, 0};
    int[] dc1 = {0, 0, -1, 1};
    
    // test between space
    int[] dr2 = {-2, 2, 0, 0};
    int[] dc2 = {0, 0, -2, 2};
    
    int[] dr3 = {-1, 1, -1, 1};
    int[] dc3 = {-1 ,-1, 1, 1};
    
    char[][] graph;
    
    boolean test1(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr1[i];
            int nc = c + dc1[i];

          if (nr < 0 || nc < 0 || nr > 4 || nc > 4) {
            continue;
          }

          if (graph[nr][nc] == 'P') {
            return false;
          }
        }
        return true;
    }
    
    boolean test2(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr2[i];
            int nc = c + dc2[i];

          if (nr < 0 || nc < 0 || nr > 4 || nc > 4) {
            continue;
          }
            if (graph[nr][nc] == 'P' 
                && graph[r + (dr2[i] / 2)][c + (dc2[i] / 2)] != 'X') {
                return false;
            }

        }
        return true;
    }
    
    boolean test3(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr3[i];
            int nc = c + dc3[i];

          if (nr < 0 || nc < 0 || nr > 4 || nc > 4) {
            continue;
          }
            if (graph[nr][nc] == 'P')  {
              if (graph[r + dr3[i]][c] != 'X') {
                return false;
              }
              if (graph[r][c + dc3[i]] != 'X') {
                return false;
              }
            }

        }
        return true;
    }
    
    
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        
        int idx = -1;
        
        for (String[] place : places) {
            idx++;
            // init
            graph = new char[5][5];
            for (int i = 0; i < place.length; i++) {
                String p = place[i];
                for (int j = 0; j < p.length(); j++) {
                    graph[i][j] = p.charAt(j);
                }
            }
            
            for (int i = 0; i < place.length; i++) {
                for (int j = 0; j < 5; j++) {
                    if (graph[i][j] == 'P') {
                        if (!test1(i, j) || !test2(i, j) || !test3(i, j)) {
                            answer[idx] = 0;
                            break;
                        }
                    }
                }
            }           
        }
        
        return answer;
    }
}