package Programmers.월간_코드_챌린지_시즌3;

class n2_배열_자르기 {
    
    // 규칙 찾고 형변환하기
    
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        for (long i = left; i <= right; i++) {
            answer[(int) (i - left)] = (int) (Math.max(i / n, i % n) + 1);
        }
        return answer;
    }
}