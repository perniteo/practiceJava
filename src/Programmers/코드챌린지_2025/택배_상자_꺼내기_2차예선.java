package Programmers.코드챌린지_2025;

class 택배_상자_꺼내기_2차예선 {

    // 최대한 greedy하게 풀어보려고 했음

    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int a = (num - 1) % w;
        
        int b = w * 2 - 1 - a * 2;
        int c = w * 2 - b;
        boolean cycle = true;
        
        while (num <= n) {
            if (cycle) {
                num += b;
            } else {
                num += c;
            }
            answer++;
            cycle = !cycle;
        }
        
        return answer;
    }
}