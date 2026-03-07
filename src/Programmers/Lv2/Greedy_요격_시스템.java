package Programmers.Lv2;

import java.util.*;

    // greedy 방법이 안 떠오를 때는 정렬하고 찍어보는 것도 도움되는 듯

    class Greedy_요격_시스템 {
        public int solution(int[][] targets) {
            int answer = 0;

            Arrays.sort(targets, (a, b) -> {
                return a[1] - b[1];
            });

            int e = -1;

            for (int i = 0; i < targets.length; i++) {

                int[] target = targets[i];
                if (target[0] >= e) {
                    answer++;
                    e = target[1];
                }
            }

            return answer;
        }
    }