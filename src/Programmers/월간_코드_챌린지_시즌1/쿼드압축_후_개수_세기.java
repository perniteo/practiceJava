package Programmers.월간_코드_챌린지_시즌1;

class 쿼드압축_후_개수_세기 {

    // divide & conquer
  
    int[][] arr;
    int[] answer = new int[2];
    
    void dfs(int r, int c, int len) {   
        int target = arr[r][c];
        
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                int next = len / 2;
                if (arr[i][j] != target) {
                    dfs(r, c, next);
                    dfs(r + next, c, next);
                    dfs(r, c + next, next);
                    dfs(r + next, c + next, next);
                    return;
                }
            }
        }
        answer[target]++;
    }
    
    public int[] solution(int[][] arr) {
        int start = arr.length;

        this.arr = arr;

        dfs(0, 0, start);
        
        return answer;
    }
}