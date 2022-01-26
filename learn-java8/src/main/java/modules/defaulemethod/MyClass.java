package modules.defaulemethod;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/25 23:17
 * 4
 */
public class MyClass implements MyInterface1, MyInterface2 {

    @Override
    public void myMethod() {
       MyInterface1.super.myMethod();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
