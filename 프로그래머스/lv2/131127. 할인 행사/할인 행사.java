import java.lang.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> m;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        m = new HashMap<>();
        
        for(int i = 0; i < 10; i++){
            if(m.get(discount[i]) == null) m.put(discount[i], 1);
            else m.put(discount[i], m.get(discount[i]) + 1);
        }
        
        if(isSatisfied(want, number)) answer += 1;
        
        for(int i = 1; i < discount.length; i++){
            if(i + 9 >= discount.length) break;
            
            String prev = discount[i - 1];
            String next = discount[i + 9];
            
            m.put(prev, m.get(prev) - 1);
            
            if(m.get(next) == null) m.put(next, 1);
            else m.put(next, m.get(next) + 1);
            
            if(isSatisfied(want, number)) answer += 1;
        }
        
        return answer;
    }
    
    public boolean isSatisfied(String[] want, int[] number){
        boolean satisfied = true;
        for(int j = 0; j < want.length; j++){
            if(m.get(want[j]) == null || m.get(want[j]) != number[j]) {
                satisfied = false;
                break;
            }
        }
        return satisfied;
    }
}