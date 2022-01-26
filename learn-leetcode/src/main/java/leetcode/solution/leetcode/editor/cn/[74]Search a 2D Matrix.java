package leetcode.solution.leetcode.editor.cn;

/**
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">搜索二维矩阵</a>
 * 在二维数组中，直接使用 length 属性获取的是数组的行数，在指定的索引后加上 length（如 array[0].length）表示的是该行拥有多少个元素，即列数
 */
class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(7 / 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int left = 0;
        // 总共有这么多个元素
        int right = r * c - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 最主要的就是元素映射到原矩阵的行和列上
            // mid/c刚好是行数,mid%c刚好是列数,注意矩阵的下标从0开始算起
            int element = matrix[mid / c][mid % c];
            if (element == target) {
                return true;
            } else if (element < target) {
                left = mid + 1;
            } else if (element > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
