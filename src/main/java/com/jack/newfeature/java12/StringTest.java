package com.jack.newfeature.java12;

import java.lang.constant.ConstantDesc;
import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) throws Exception {
        // indent method is used for indenting a fixed number of spaces
        String originalText = "line1\nline2\nline3";
        // 使用indent方法添加缩进，这里指定缩进4个空格
        String indentedText = originalText.indent(4);
        System.out.println(indentedText);

        String[] lines = {"line1", "line2", "line3"};
        String joinedLines = Stream.of(lines)
                .collect(StringBuilder::new, (sb, line) -> sb.append(line).append("\n"), StringBuilder::append)
                .toString();
        System.out.println("Before indent: \n" + joinedLines);
        String indentedJoinedLines = joinedLines.indent(2);
        System.out.println("After indent: \n" + indentedJoinedLines);


        // transform method is used for transforming a string according to a given format
        originalText = "Hello, World!";
        String transformedText = originalText.transform(String::toUpperCase);
        System.out.println("原始字符串: " + originalText);
        System.out.println("转换后的字符串: " + transformedText);

        Function<String, String> addPrefixFunction = s -> "Prefix: " + s;
        String anotherTransformedString = originalText.transform(addPrefixFunction);
        System.out.println("另一种转换后的字符串: " + anotherTransformedString);

        String str = "hello";
        Optional<?> optionalConstable = str.describeConstable();
        if (optionalConstable.isPresent()) {
            System.out.println("The constant value is: " + optionalConstable.get());
        }

        ConstantDesc constantDesc = (ConstantDesc) optionalConstable.get();
        Object resolvedValue = constantDesc.resolveConstantDesc(MethodHandles.lookup());
        System.out.println(resolvedValue);
    }
}
