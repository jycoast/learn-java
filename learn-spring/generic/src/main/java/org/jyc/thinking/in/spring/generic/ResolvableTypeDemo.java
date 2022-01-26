package org.jyc.thinking.in.spring.generic;

import org.springframework.core.GenericTypeResolver;
import org.springframework.core.ResolvableType;

import javax.naming.spi.Resolver;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@link ResolvableType}示例
 *
 * @author jiyongchao
 */
public class ResolvableTypeDemo {
    public static void main(String[] args) throws Exception {
        // 工厂创建
        // StringList <- ArrayList <- AbstractList <- list
        ResolvableType resolvableType = ResolvableType.forClass(GenericTypeResolverDemo.StringList.class);
        resolvableType.getSuperType(); //ArrayList
        resolvableType.getSuperType().getSuperType(); // AbstractList

        System.out.println(resolvableType.asCollection().resolve()); //获取Raw Type
        System.out.println(resolvableType.asCollection().resolveGeneric(0)); // 获取泛型参数类型
    }
}