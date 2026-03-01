package Programmers.KAKAO.BLIND2020;

class String_문자열_압축 {

  // 다시 풀어볼 필요 있음

    public int solution(String s) {
        int answer = s.length();
        
        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder sb = new StringBuilder();
            
            int count = 0;
            String prev = "";
            
            for (int i = 0; i < s.length(); i += len) {
                int end = Math.min(i + len, s.length());
                
                String cur = s.substring(i, end);
                
                if (cur.equals(prev)) {
                    count++;
                } else {
                  if (count > 1) {
                    sb.append(count);
                  }
                  if (count > 0) {
                    sb.append(prev);
                  }
                    
                    prev = cur;
                    count = 1;
                }
            }

          if (count > 1) {
            sb.append(count);
          }
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
            
        return answer;
    }
}