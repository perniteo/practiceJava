package Programmers.Lv2;

class 혼자서_하는_틱택토 {

  // 구현
    
    String[] board;
    
    boolean win(char t) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == t 
                && board[i].charAt(1) == t && board[i].charAt(2) == t) {
                return true;
            }
            
            if (board[1].charAt(i) == t 
                && board[2].charAt(i) == t && board[0].charAt(i) == t) {
                return true;
            }
        }
        
        if (board[0].charAt(0) == t 
            && board[1].charAt(1) == t && board[2].charAt(2) == t) {
            return true;
        }
        if (board[0].charAt(2) == t 
            && board[1].charAt(1) == t && board[2].charAt(0) == t) {
            return true;
        }
        
        return false;
    }
    
    public int solution(String[] board) {
        int answer = 1;
        
        int oCount = 0;
        int xCount = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
              if (c == 'O') {
                oCount++;
              } else if (c == 'X') {
                xCount++;
              }
            }
        }
        
        this.board = board;
        
        boolean O = win('O');
        boolean X = win('X');

      if (O && X) {
        return 0;
      } else if (O && !X && oCount <= xCount) {
        return 0;
      } else if (!O && X && oCount > xCount) {
        return 0;
      } else if (!O && !X && oCount < xCount) {
        return 0;
      } else if (xCount > oCount || Math.abs(oCount - xCount) > 1) {
        return 0;
      }
        
        return answer;
    }
}