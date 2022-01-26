package leetcode.template;

/**
 * 递归代码模板
 *
 * <pre>
 *     public void recursion(int level, param1, param2,...) {
 *     // 递归的终止条件
 *     if (level > MAX_LEVEL) {
 *         process_result;
 *         return;
 *     }
 *     // 处理当前层逻辑
 *     process(level, data...);
 *
 *     // 下探到下一层
 *     recursion(level + 1, newParam);
 *
 *     // 如果有必要的话清理当前层不需要的全局变量或者其他东西
 * }
 * </pre>
 *
 * <p>
 * 处理递归问题的思维要点：1.抛弃人肉递归 2.找到最近重复子问题 3.数学归纳法的思维
 * </p>
 */
public class Recursion {

}
