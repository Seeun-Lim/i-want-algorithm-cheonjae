import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Pos{
        int x, y, depth;
        public Pos(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    public int solution(int[][] maps) {
        return BFS(maps);
    }
    public static int BFS(int[][] maps){
        int r = maps.length;
        int c = maps[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[r][c];

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            for (int i = 0; i < 4; i++){
                int dr = poll.x + dir[i][0];
                int dc = poll.y + dir[i][1];

                if(dr == r - 1 && dc == c - 1){
                    return poll.depth + 1;
                }

                if(dr < 0 || dr >= r || dc < 0 || dc >= c || visited[dr][dc] || maps[dr][dc] == 0){
                    continue;
                }

                queue.add(new Pos(dr, dc, poll.depth + 1));
                visited[dr][dc] = true;
            }
        }

        return -1;
    }
}