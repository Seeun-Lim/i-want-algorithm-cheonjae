import java.lang.*;
import java.util.*;

class Solution {
    static Map<String, People> m;
    static class People {
        String ref, name;
        int earn;
        
        People(String name, String ref){
            this.name = name;
            this.ref = ref;
            this.earn = 0;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        m = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++){
            m.put(enroll[i], new People(enroll[i], referral[i]));
        }
        
        for(int i = 0; i < seller.length; i++){
            distribute(m.get(seller[i]), amount[i] * 100);
        }
        
        for(int i = 0; i < enroll.length; i++){
            answer[i] = m.get(enroll[i]).earn;
        }
        
        return answer;
    }
    
    public static void distribute(People p, int earning){
        p.earn += Math.ceil(earning * 0.9);
        if(p.ref.equals("-") ) return;
        if((int)(earning * 0.1) >= 1) distribute(m.get(p.ref), (int)(earning * 0.1));
    }
}