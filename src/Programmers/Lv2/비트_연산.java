package Programmers.Lv2;

class 비트_연산 {

    // 2개 이하로 다른 비트
    // 짝수면 + 1, 홀수면 뒤에서 부터 읽고 처음 0 나오는 idx <-> -1 idx 지점과 바꾸면 된다고 생각
    // 저 말은 곧 -1 idx 지점을 ++ 해주는 비트 연산
    // 직접 나눠서 구하든 toBinaryString 변환하여 풀까 했으나 남은 건 구현이라 비트 연산 공식 참고했음

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                answer[i] = num + 1 + ((num ^ (num + 1)) >> 2);
            }
        }
        
        return answer;
    }
}