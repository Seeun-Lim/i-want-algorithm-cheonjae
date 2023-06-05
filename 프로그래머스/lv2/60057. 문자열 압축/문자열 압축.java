class Solution {
    static int size, strSize;
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        size = s.length();
        
        if(size == 1) return 1;
        
        for (int i = 1; i <= size / 2; i++) {
        	strSize = 0;
        	dfs(0, i, "", s, 0);
        	answer = answer > strSize? strSize : answer;
		}
        return answer;
    }
    
    private static void dfs(int start, int length, String search, String origin, int r){
		if(start > size - 1 || start + length > size) {
			if(r > 1) strSize += (length + (int)( Math.log10(r) + 1));
			else strSize += length;
			
			strSize += (size - start);
			return;
		}
		
		String cur = "";
		for (int i = start; i < start + length; i++) {
			cur += origin.charAt(i);
		}
		
		if(start == 0) {
			dfs(start + length, length, cur, origin, 1);
		} else if(cur.equals(search)) {
			dfs(start + length, length, search, origin, r + 1);
		} else if(!cur.equals(search)) {
			if(r > 1) strSize += (length + (int)( Math.log10(r) + 1));
			else strSize += length;
			dfs(start + length, length, cur, origin, 1);
		}
	}
}