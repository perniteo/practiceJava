package Programmers.월간_코드_챌린지_시즌1;

class 삼각_달팽이 {

    // 더해가는 direction 변경
    
    int[] dr = {1, 0, -1};
    int[] dc = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        arr[0][0] = 1;
        
        int number = 1;
        
        int end = n * (n + 1) / 2;
        
        int r = 0;
        int c = 0;
        int dir = 0; 
        
        while (number < end) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n || arr[nr][nc] != 0) {
                dir = (dir + 1) % 3;
            } else {
                r = nr;
                c = nc;
                arr[r][c] = ++number;
            }
        }
        
        int[] answer = new int[end];
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}