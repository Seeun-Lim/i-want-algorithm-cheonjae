// N / 2 마리의 포켓몬
// [3, 1, 2, 3] 이면 3 - 2마리, 1 - 1마리, 2 - 1마리 : 총 4마리 3종류
// 4마리의 포켓몬 중 2마리 고르기
// 가장 많은 종류의 포켓몬을 선택하는 방법
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i]) + 1);
            } else m.put(nums[i], 1);
        }
        
        answer = nums.length / 2 > m.keySet().size() ? m.keySet().size() : nums.length / 2;
        
        return answer;
    }
}