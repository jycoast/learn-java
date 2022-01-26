package modules.defaulemethod;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/25 23:33
 * 4
 */
public class MyClass2 extends MyInterface1Impl implements MyInterface2 {
    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        myClass2.myMethod();
    }
}
