package BaekAlgo.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자_카드_2_10816 {

  // hashMap 을 사용한 간단한 count

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }


    int m = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    Map<Integer, Integer> map = new HashMap<>(m);

    int[] cards = new int[m];

    for (int i = 0; i < m; i++) {
      int card = Integer.parseInt(st.nextToken());
      map.putIfAbsent(card, 0);
      cards[i] = card;
    }

    for (int i : arr) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      }
    }
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      sb.append(map.get(cards[i])).append(" ");
    }
    System.out.println(sb.toString().trim());
  }
}