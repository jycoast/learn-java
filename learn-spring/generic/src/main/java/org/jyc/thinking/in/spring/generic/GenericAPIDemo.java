package org.jyc.thinking.in.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 反射API示例
 *
 * @author jiyongchao
 */
public class GenericAPIDemo {
    public static void main(String[] args) {
        // 原生类型 int long float
        Class intClass = int.class;
        // 数组类型 int[],Object[]
        Class objectArrayClass = Object[].class;
        // 原始类型 raw types: java.lang.String
        Class rawClass = String.class;

        // 泛型参数类型 parameterized Type
        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();

        // parameterizedType.getRawType() = java.util.AbstractList;

        //泛型类型变量 Type Variable

        System.out.println(parameterizedType.toString());

        // <E>
        Type[] typeVariables = parameterizedType.getActualTypeArguments();
//        Stream.of(parameterizedType.getActualTypeArguments()).forEach(System.out::println);
        Stream.of(typeVariables).map(TypeVariable.class::cast).forEach(System.out::println);
    }
}
