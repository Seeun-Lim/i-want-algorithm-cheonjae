class Solution {
    static int size, answer;
	static boolean visited[];
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        size = dungeons.length;
        visited = new boolean[size];
        for (int i = size; i > 0; i--) {
			perm(0, i, k, dungeons);
			if(answer != -1) break;
		}
        
        return answer;
    }
    
    private static void perm(int depth, int total, int power, int[][] arr) {
		if(depth == total) {
			answer = depth;
			return;
		}
		
		if(power < 0) return;
		
		for (int i = 0; i < size; i++) {
			if(!visited[i] && power >= arr[i][0]) {
				visited[i] = true;
				perm(depth + 1,total, power - arr[i][1], arr);
				if(answer != -1) break;
				visited[i] = false;
			}
		}
	}
}