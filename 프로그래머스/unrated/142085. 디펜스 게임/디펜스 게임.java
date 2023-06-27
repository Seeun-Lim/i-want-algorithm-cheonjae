import java.lang.*;
import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        if(k >= enemy.length) return enemy.length;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < enemy.length; i++){
            q.add(enemy[i]);
            
            // 더이상 감당 안대.....무적권으로
            if(q.size() > k) n -= q.poll();
            
            // 게임 끝
            if(n < 0) return i;
        }
        
        return answer;
    }
}