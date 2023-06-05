class Solution {
    public int solution(int[][] sizes) {        
        int[] wa = new int[2];
        
        if(sizes[0][0] > sizes[0][1]) wa = new int[]{sizes[0][0], sizes[0][1]};
        else wa = new int[]{sizes[0][1], sizes[0][0]};
        
        for(int i = 1; i < sizes.length; i++){
            int newW = sizes[i][0] >= sizes[i][1] ? sizes[i][0] : sizes[i][1];
            int newH = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
            
            wa[0] = newW > wa[0]? newW : wa[0];
            wa[1] = newH > wa[1]? newH : wa[1];
        }
        
        return wa[0] * wa[1];
    }
}