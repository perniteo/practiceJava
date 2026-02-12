package Programmers.KAKAO.BLIND2018;

class Impl_프렌즈4블록_1차 {

  // 중력(정렬 방향)을 회전해서 블록 정렬을 편하게 바꿨음
  // 정렬은 two-pointer 활용

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] nBoard = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nBoard[i][j] = board[m-j-1].charAt(i);
            }
        }
        
        while (true) {
            int count = 0;
            boolean[][] check = new boolean[n][m];
            
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                  if (nBoard[i][j] == ' ') {
                    continue;
                  }
                    if (nBoard[i][j] == nBoard[i+1][j]
                        && nBoard[i][j] == nBoard[i+1][j+1]
                        && nBoard[i][j] == nBoard[i][j+1]) {
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check[i][j]) {
                        count++;
                        nBoard[i][j] = ' ';
                    }
                }
            }

          if (count == 0) {
            break;
          }
            answer += count;
            
            for (int i = 0; i < n; i++) {
                int write = 0;
                
                for (int j = 0; j < m; j++) {
                    if (nBoard[i][j] != ' ') {
                        nBoard[i][write] = nBoard[i][j];
                        write++;
                    }
                }
                while (write < m) {
                    nBoard[i][write] = ' ';
                    write++;
                }
            }
        }
        
        return answer;
    }
}