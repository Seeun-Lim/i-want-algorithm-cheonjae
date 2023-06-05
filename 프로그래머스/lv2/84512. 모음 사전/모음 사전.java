import java.util.*;

class Solution {
    static int answer;
    static boolean isFind;
    static List<String> w;
    static String[] s = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        answer = 0;
        w = new ArrayList<>();
        isFind = false;
        dfs(0, word, "");
        return answer;
    }
    
    public void dfs(int depth, String word, String words){        
        if(words.equals(word)) {
            isFind = true;
            return;
        }
        answer += 1;
        
        if(depth == 5) return;
        
        for(int i = 0; i < 5 && !isFind; i++){
            dfs(depth + 1, word, words + s[i]);
        }
    }
    
}