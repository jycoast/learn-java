package modules.FunctionalInterface;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/5 14:22
 * 4
 */
public class Essence {
    public static void main(String[] args) {
        InterfaceTestA interfaceTestA = () -> {};

        InterfaceTestB interfaceTestB = () -> {};
    }
}

interface InterfaceTestA {

    void myMethod();
}

interface InterfaceTestB {

    void myMethod2();
}