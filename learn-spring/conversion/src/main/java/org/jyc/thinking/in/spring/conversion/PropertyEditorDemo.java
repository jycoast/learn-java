package org.jyc.thinking.in.spring.conversion;

import java.beans.PropertyEditor;

/**
 * {@link java.beans.PropertyEditor} 示例
 *
 * @author jiyongchao
 */
public class PropertyEditorDemo {
    public static void main(String[] args) {
        // 模拟Spring Framework的操作
        // 有一段文本name = "吉永超";
        String text = "name = 吉永超";
        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        propertyEditor.setAsText(text);
        System.out.println(propertyEditor.getValue());
        System.out.println(propertyEditor.getAsText());
    }
}
