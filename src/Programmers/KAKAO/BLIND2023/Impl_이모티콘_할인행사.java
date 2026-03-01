package Programmers.KAKAO.BLIND2023;

class Impl_이모티콘_할인행사 {

    // dfs(조합) 구현

    boolean[] visited;
    
    int[] discount = new int[]{10, 20, 30, 40};
    
    int[] emoticons;
    
    int[] selected;
    
    int[][] users;
    
    int result1 = 0;
    int result2 = 0;
    
    void dfs(int depth) {
        if (depth == emoticons.length) {
            int service = 0;
            int sumPrice = 0;
            for (int i = 0; i < users.length; i++) {
                int[] user = users[i];
                
                int sumBuy = 0;
                
                for (int e = 0; e < emoticons.length; e++) {
                    if (user[0] <= selected[e]) {
                        sumBuy += emoticons[e] / 100 * (100 - selected[e]);
                    }
                }
                if (user[1] <= sumBuy) {
                    service++;
                } else {
                    sumPrice += sumBuy;
                }
            }
            if (service > result1) {
                result1 = service;
                result2 = sumPrice;
            } else if (service == result1 && sumPrice > result2) {
                result2 = sumPrice;
            }
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            selected[depth] = discount[d];
            dfs(depth + 1);
        }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) { 
        visited = new boolean[emoticons.length];
        
        selected = new int[emoticons.length];
        
        this.emoticons = emoticons;
        this.users = users;
        
        dfs(0);   
        
        return new int[]{result1, result2};
    }
}