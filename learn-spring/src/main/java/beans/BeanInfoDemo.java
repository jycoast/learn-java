package beans;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * 类型转换和元信息配置
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            // propertyDescriptor允许添加属性编辑器 - PropertyEditor
            // GUI -> text(String) -> PropertyType
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();
            if ("age".equals(propertyName)) {
                // String -> Integer   Integer.valueOf("")
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                propertyDescriptor.createPropertyEditor()
            }
        });


    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
