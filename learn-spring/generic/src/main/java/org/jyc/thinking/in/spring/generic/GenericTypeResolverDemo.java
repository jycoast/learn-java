package org.jyc.thinking.in.spring.generic;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.core.GenericTypeResolver;
import sun.java2d.windows.GDIWindowSurfaceData;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GenericTypeResolver示例
 *
 * @author jiyongchao
 */
public class GenericTypeResolverDemo {
    public static void main(String[] args) throws Exception {
        // String Comparable<String> 具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, Comparable.class, "getString");
        // ArrayList<Object>是List泛型参数类型的具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getList");
        // StringList也是List泛型类型的具体化
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getStringList");
        // 具备 ParameterizedType返回。否则null
        // TypeVariable
        Map<TypeVariable, Type> typeVariableMap = GenericTypeResolver.getTypeVariableMap(StringList.class);
        System.out.println(typeVariableMap);
    }

    public static StringList getStringList() {
        return null;
    }

    public static ArrayList<Object> getList() { // 泛型参数具体化（字节码有记录）
        return null;
    }

    public static String getString() {
        return null;
    }

    private static void displayReturnTypeGenericInfo(Class<?> containingClass, Class<?> generic, String methodName, Class... argumentTypes) throws Exception {
        Method method = containingClass.getMethod(methodName, argumentTypes);

        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, containingClass);

        Class<?> returnTypeArgument = GenericTypeResolver.resolveReturnTypeArgument(method, generic);

        // 常规类作为方法返回值
        System.out.printf("GenericTypeResolver.resolveReturnType(%s,%s) = %s\n", methodName, containingClass.getSimpleName(), returnType);
        // 常规类型不具备泛型参数类型List<E>
        System.out.printf("GenericTypeResolver.resolveReturnTypeArgument(%s,%s) = %s\n", methodName, containingClass.getSimpleName(), returnTypeArgument);
    }

    static class StringList extends ArrayList<String> { // 泛型参数具体化（字节码有记录）

    }
}
