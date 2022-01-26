package leetcode.solution;

/**
 * 该reverse(int x)函数反转的十进制数字x。例如，if x = 102，它返回201，如果x = -102返回-201。
 *
 * x计算反向时，将其存储在rev。例如，对于x = 102，rev取连续值2，20，201。
 *
 * 在每次迭代时，rev乘以10，并向其添加一位数。当然，rev不能大于Integer.MAX_VALUE（2147483647）。因此，乘前rev通过10，我们检查是否乘以它10并加入pop将使其大于Integer.MAX_VALUE。
 *
 * 我们首先检查是否rev大于Integer.MAX_VALUE / 10（214748364）。如果它更大，则不存在反向整数。如果不是，那么rev小于或等于Integer.MAX_VALUE / 10。如果它小于Integer.MAX_VALUE / 10，那么即使我们乘以它10，我们也可以添加任何数字（pop），我们不会超过Integer.MAX_VALUE。但是，如果它等于Integer.MAX_VALUE / 10，那么我们必须确保pop不是> 7（2147483647 - 214748364 * 10）因为否则我们会超过Integer.MAX_VALUE
 *
 * @see <a href="http://google.com">http://google.com</a>
 */
public class MyAtoi {

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("211"));
    }

    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        // 空字符串
        if (str.length() == 0) {
            return 0;
        }
        // 移除空格
        while (str.charAt(index) == ' ') {
            index++;
        }
        // 处理正负号
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // 转为数字
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // 越界处理
            if (Integer.MAX_VALUE / 10 < total ||
                    (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                // 211 = 2 -> 2*10 -> 2*10*10 + 1
                total = 10 * total + digit;
                index++;
            }
        }
        return total * sign;
    }
}
