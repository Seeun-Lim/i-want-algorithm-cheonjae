class Solution {
    static int answer;
    static boolean visited[];
    
    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                answer += 1;
                DFS(i, computers, n);
            }
        }

        return answer;
    }

    public static void DFS(int a, int[][] computers, int n){
        if(a == n) return;

        for (int i = 0; i < n; i++) {
            if(a != i && computers[a][i] == 1 && !visited[i]){
                visited[i] = true;
                DFS(i, computers, n);
            }
        }
    }
}