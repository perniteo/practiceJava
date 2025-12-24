package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스택_2_28278 {

  // 스택의 역할만 하게 하기에는 arrayList 보다는
  // arrayDeque 쓰는 것이 더 좋았을듯

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    List<Integer> list = new ArrayList<>();

    StringTokenizer st;

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int command = Integer.parseInt(st.nextToken());

      switch (command) {
        case 1:
          int num = Integer.parseInt(st.nextToken());
          list.add(num);
          break;
        case 2:
          if (list.isEmpty()) {
            bw.write(-1 + "\n");
          } else {
            bw.write(list.remove(list.size() - 1) + "\n");
          }
          break;
        case 3:
          bw.write(list.size() + "\n");
          break;
        case 4:
          if (list.isEmpty()) {
            bw.write(1 + "\n");
          } else {
            bw.write(0 + "\n");
          }
          break;
        case 5:
          if (list.isEmpty()) {
            bw.write(-1 + "\n");
          } else {
            bw.write(list.get(list.size() - 1) + "\n");
          }
          break;
      }
    }

    bw.flush();
  }
}