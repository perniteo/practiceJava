package Programmers.Lv3;

import java.util.*;

class Hash_Sort_베스트앨범 {

    // hash 자료구조와 sort 사용하기

    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<int[]>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            List<int[]> list = map.getOrDefault(genre, new ArrayList<>());
            list.add(new int[]{play, i});
            map.put(genre, list);
        }

        Map<String, Integer> playSum = new HashMap<>();

        for (Map.Entry<String, List<int[]>> e : map.entrySet()) {
            String g = e.getKey();
            List<int[]> p = e.getValue();

            int sum = 0;

            for (int[] info : p) {
                sum += info[0];
            }
            playSum.put(g, sum);
        }

        List<String> sorted = new ArrayList<>(playSum.keySet());

        sorted.sort((a, b) -> {
            return playSum.get(b) - playSum.get(a);
        });

        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < sorted.size(); i++) {
            String genre = sorted.get(i);
            
            List<int[]> l = map.get(genre);
            l.sort((a, b) -> {
                return b[0] - a[0];
            });
            
            int song = Math.min(l.size(), 2);
            
            for (int j = 0; j < song; j++) {
                int[] s = l.get(j);
                result.add(s[1]);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}