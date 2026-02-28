package Programmers.Lv2;

class Greedy_광물_캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPick = picks[0] + picks[1] + picks[2];
        int maxMineral = Math.min(minerals.length, totalPick * 5);

        int size = (maxMineral + 4) / 5;
        
        int[] point = new int[size];
        
        for (int i = 0; i < maxMineral; i++) {
            String m = minerals[i];
            
            if (m.equals("diamond")) {
                point[i/5] += 25;
            } else if (m.equals("iron")) {
                point[i/5] += 5;
            } else {
                point[i/5] += 1;
            }
        }
        
        while (true) {
            int max = 0;
            int mIdx = 0;
            for (int i = 0; i < size; i++) {
                if (max < point[i]) {
                    max = Math.max(max, point[i]);
                    mIdx = i;
                }
            }
          if (max == 0) {
            break;
          }
            
            point[mIdx] = 0;
            
            int pick = -1;
            for (int i = 0; i <= 2; i++) {
                if (pick == -1 && picks[i] > 0) {
                    pick = i;
                    picks[i]--;
                }
            }
          if (pick == -1) {
            break;
          }
            
            if (mIdx * 5 + 5 > minerals.length) {
                for (int i = mIdx * 5; i < minerals.length; i++) {
                    if (pick == 0) {
                        answer++;
                    } else if (pick == 1) {
                        if (minerals[i].equals("diamond")) {
                            answer += 5;
                        } else {
                            answer++;
                        }
                    } else {
                        if (minerals[i].equals("diamond")) {
                            answer += 25;
                        } else if (minerals[i].equals("iron")) {
                            answer += 5;
                        } else {
                            answer++;
                        }
                    }
                }
            } else {
                for (int i = mIdx * 5; i < mIdx * 5 + 5; i++) {
                    if (pick == 0) {
                        answer++;
                    } else if (pick == 1) {
                        if (minerals[i].equals("diamond")) {
                            answer += 5;
                        } else {
                            answer++;
                        }
                    } else {
                        if (minerals[i].equals("diamond")) {
                            answer += 25;
                        } else if (minerals[i].equals("iron")) {
                            answer += 5;
                        } else {
                            answer++;
                        }
                }
            }
        }
        }
        
        return answer;
    }
}