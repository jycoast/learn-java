package modules.FunctionalInterface;

import java.util.function.Supplier;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/19 23:09
 * 4
 */
public class SupplierJyc {
    public static void main(String[] args) {
        Supplier<String> supplierJyc = () -> "hello word";
        System.out.println(supplierJyc.get());
    }
}
