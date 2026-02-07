package Programmers.Lv2;

class 롤케이크_자르기 {

  // hashMap or int[]

    public int solution(int[] topping) {
        int answer = 0;
        
        int[] a = new int[10001];
        int[] b = new int[10001];
        
        a[topping[0]]++;
        
        int aCount = 1;
        int bCount = 0;
        
        for (int i = 1; i < topping.length; i++) {
            int t = topping[i];
            
            if (b[t] == 0) {
                bCount++;
            }
            b[t]++;
        }

      if (aCount == bCount) {
        answer++;
      }
        
        for (int i = 1; i < topping.length; i++) {
            int t = topping[i];
            
            if (b[t] == 1) {
                bCount--;
            }
            if (a[t] == 0) {
                aCount++;
            }
            b[t]--;
            a[t]++;

          if (aCount == bCount) {
            answer++;
          }
        }
     
        return answer;
    }
}