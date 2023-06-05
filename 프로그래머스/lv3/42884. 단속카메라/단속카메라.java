import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
        });
        
        int end = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            // 현재 end와 그 다음 순서 start 사이에 틈이 있을 때 : end 옮겨줌
            if(routes[i][0] > end){
                end = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}