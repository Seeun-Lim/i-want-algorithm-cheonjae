import java.util.*;

class Solution {
    static class WaitingList{
        int priority;
        int index;
        
        WaitingList(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<WaitingList> dq = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            dq.offer(new WaitingList(priorities[i], i));
        }
        
        while(true){
            WaitingList doc = dq.pollFirst();
            
            boolean isFirst = true;
            Deque<WaitingList> ndq = new LinkedList<>();
            
            while(!dq.isEmpty()){
                WaitingList ndoc = dq.pollFirst();
                if(ndoc.priority > doc.priority) isFirst = false;                  
                ndq.add(ndoc);
            }
            
            if(!isFirst) ndq.add(doc);
            else{
                answer += 1;
                if(doc.index == location){
                    break;
                }
            }
           
            dq = ndq;
        }
        
        return answer;
    }
}