package Programmers.Lv2;

class TP_연속된_부분_수열합 {

    // two-pointer

    public int[] solution(int[] sequence, int k) {
        int i = 0;
        int j = 0;
        
        int left = 0;
        int right = 0;
        
        int minLen = Integer.MAX_VALUE;
        
        int sum = 0;
        
        while (j < sequence.length) {
            sum += sequence[j];

            while (sum >= k) {
                if (sum == k && j - i + 1< minLen) {
                    minLen = j - i + 1;
                    left = i;
                    right = j;
                }
                sum -= sequence[i++];
            }
            j++;
        }
        
        int[] answer = {left, right};
        return answer;
    }
}