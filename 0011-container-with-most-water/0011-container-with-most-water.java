class Solution {
    public int maxArea(int[] height) {
        int lb = 0, rb = height.length-1, maxCap = 0;
        while(lb < rb) {
            
            int ht = Math.min(height[lb], height[rb]);
            int width =  rb - lb;
            maxCap = Math.max(maxCap, ht * width);

            if(height[lb] <= height[rb]) {
                lb++;
            }
            else {
                rb--;
            }
        }
        return maxCap;
    }
}