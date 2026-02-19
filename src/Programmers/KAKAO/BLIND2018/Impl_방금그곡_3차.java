package Programmers.KAKAO.BLIND2018;

class Impl_방금그곡_3차 {

  // 동일곡 처리, 곡 포함 여부 검사에서 부등호 처리 때문에 시간이 많이 끌렸음
  // 또한 #을 포함한 음들을 1글자로 임의 매핑해서 더 편하게 구현 가능

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        int longest = 0;
        
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int start = Integer.parseInt(info[0].substring(0, 2)) * 60
                + Integer.parseInt(info[0].substring(3, 5));
            int end = Integer.parseInt(info[1].substring(0, 2)) * 60
                + Integer.parseInt(info[1].substring(3, 5));
            int playtime = end - start;
            
            StringBuilder sb = new StringBuilder();
            
            int idx = 0;
            String music = info[3];
            int len = music.length();
            
            for (int i = 0; i < playtime; i++) {
                sb.append(music.charAt(idx++));
                if (idx < len && music.charAt(idx) == '#') {
                    sb.append(music.charAt(idx++));
                }
                idx %= len;
            }
            
            for (int i = 0; i <= sb.length() - m.length(); i++) {
                int next = i + m.length();
                if (sb.toString().startsWith(m, i)) {
                  if (next < sb.length()
                      && sb.toString().charAt(next) == '#') {
                    continue;
                  } else {
                    if (playtime > longest) {
                      answer = info[2];
                      longest = playtime;
                    }
                  }
                }
            }
        }
        
        return answer;
    }
}