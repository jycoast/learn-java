package leetcode.solution.leetcode.editor.cn;


/**
 * @see <a href = "https://leetcode-cn.com/problems/container-with-most-water/">盛水最多的容器</a>
 */
class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater.maxArea(height));
    }

    private int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            int h = Math.min(height[i],height[j]);
            int res = h * (j - i);
            max = Math.max(res,max);
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

//    public int maxArea(int[] height) {
//        if (height == null || height.length <= 2) {
//            return 0;
//        }
//        int max = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int hg = Math.min(height[i], height[j]);
//                int area = Math.abs(j - i) * hg;
//                max = Math.max(max,area);
//            }
//        }
//        return max;
//    }
}
