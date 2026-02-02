package Programmers.Lv2;

class DC_행렬의_곱셈 {
    
    // d&c 구조의 행렬 곱셈
    // recursion 없기 때문에 알고리즘 상으로 d&c라고 하기엔 무리
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int aRow = arr1.length;
        int aCol = arr1[0].length;
        
        int bRow = aCol; // arr2.length;
        int bCol = arr2[0].length;
        
        int[][] answer = new int[aRow][bCol];
        
        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < bCol; j++) {
                int sum = 0;
                for (int k = 0; k < aCol; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}