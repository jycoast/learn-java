package modules.FunctionalInterface;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2019/12/30 22:53
 * 4
 */

@FunctionalInterface
interface MyInterface {
    void test();

    @Override
    String toString();
}

public class FunctionalInterfaceTest {

    public void MyTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }
    public static void main(String[] args) {
        FunctionalInterfaceTest functionalInterfaceTest = new FunctionalInterfaceTest();
        MyInterface myInterface = () -> System.out.println("myTest");
        functionalInterfaceTest.MyTest(myInterface);
    }
}
