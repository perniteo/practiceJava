package Programmers.KAKAO.BLIND2018;

import java.util.*;

class Impl_파일명_정렬_3차 {
    
    class File {
        String head;
        String number;
        String tail;
        File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
    
        ArrayList<File> list = new ArrayList<>();
        
        for (String file : files) {
            File f;
            boolean head = false;
            boolean number = false;
            boolean tail = false;
            StringBuilder hsb = new StringBuilder();
            StringBuilder nsb = new StringBuilder();
            StringBuilder tsb = new StringBuilder();
            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);

              if (Character.isDigit(c) && !head) {
                head = true;
              }
              if (!Character.isDigit(c) && head) {
                number = true;
              }
                
                if (!head) {
                    hsb.append(c);
                    continue;
                }
                if (!number) {
                    nsb.append(c);
                    continue;
                }
                if (!tail) {
                    tsb.append(c);
                    continue;
                }
            }
            f = new File(hsb.toString()
                         , nsb.toString()
                         , tsb.toString());
            list.add(f);
        }
        
        list.sort((a, b) -> {
          if (a.head.toLowerCase()
              .equals(b.head.toLowerCase())) {
            return Integer.parseInt(a.number) - Integer.parseInt(b.number);
          } else {
            return a.head.toLowerCase().compareTo(b.head.toLowerCase());
          }
        });
        
        for (int i = 0; i < files.length; i++) {
            File f = list.get(i);
            answer[i] = f.head + f.number + f.tail;
        }
        
        return answer;
    }
}