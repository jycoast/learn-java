package leetcode.solution.leetcode.editor.cn;

class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleInHistogram.largestRectangleArea(height));
    }

    /**
     * 使用暴力求解
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            // 向左遍历，找到大于等于当前柱形高度最左元素的下标
            int left = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            // 向右遍历，找到大于等于当前柱形高度最右元素的下标，注意这里的边界条件
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }
}
