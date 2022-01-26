package demo.modules.base;

/**
 * 测试finally中的代码块是否一定会执行
 *
 * @author jiyongchao
 */
public class FinallyInvokeTest {
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.err.println("发生异常：" + e.getMessage());
            System.exit(0);
        } finally {
            System.out.println("finally invoked!");
        }
    }
}