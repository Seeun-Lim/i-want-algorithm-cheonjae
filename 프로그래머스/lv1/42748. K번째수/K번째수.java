import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] copy;
            if(commands[i][0] == commands[i][1]) {
                copy =  new int[]{array[commands[i][0] - 1]};
            } else copy = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(copy);
            answer[i] = copy[commands[i][2] - 1];
        }
        return answer;
    }
}