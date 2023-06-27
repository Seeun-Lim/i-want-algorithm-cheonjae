class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            answer[i] = check(places[i]);
            // System.out.println("--------");
        }
        
        return answer;
    }
    
    public static int check(String[] p){
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(p[i].charAt(j) == 'P'){
                    // 사람 앉은 자리 검사
                    // System.out.println("start : " + i + " " + j);
                    
                    for(int k = 0; k < 4; k++){
                        int dx = dir[k][0] + i;
                        int dy = dir[k][1] + j;
                        
                        if(!isIn(dx, dy)) continue;
                        if(p[dx].charAt(dy) == 'P') return 0;
                        
                        if(p[dx].charAt(dy) == 'O'){
                            // 그 다음 징검다리 확인
                            if(isIn(dx + dir[k][0], dy + dir[k][1]) && p[dx + dir[k][0]].charAt(dy + dir[k][1]) == 'P') {
                                // System.out.println("옆 새끼 : " + dx + dir[k][0] + " " + dy + dir[k][1]);
                                return 0;
                            }
                            
                            if(dir[k][1] == 0) {
                                if(isIn(dx, dy + 1) && p[dx].charAt(dy + 1) == 'P') {
                                // System.out.println("사방 새끼 dy + 1: " + dx + " " + dy + 1);
                                return 0;
                            }
                                else if(isIn(dx, dy - 1) && p[dx].charAt(dy - 1) == 'P')  {
                                // System.out.println("사방 새끼 dy - 1: " + dx + " " + (dy - 1));
                                return 0;
                            }
                            }
                            else {
                                if(isIn(dx + 1, dy) && p[dx + 1].charAt(dy) == 'P') return 0;
                                else if(isIn(dx - 1, dy) && p[dx - 1].charAt(dy) == 'P') return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
    
    static boolean isIn(int dx, int dy){
        if(dx < 0 || dy < 0 || dx >= 5 || dy >= 5) return false;
        return true;
    }
}