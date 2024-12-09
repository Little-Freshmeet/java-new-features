package com.jack.newfeature.java11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class FilesTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = FilesTest.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource("application.json").toURI());
        System.out.println(Files.readString(path));

        Path filePath = Paths.get("src/main/resources/application.json");
        System.out.println(Files.readString(filePath));

        // write content to new file
        String content = """
                {
                    "name": "jack",
                    "age": 18
                }
                """;
        String relativePath = "resources/output.json";
        Path targetFilePath = Paths.get(Objects.requireNonNull(FilesTest.class.getClassLoader().getResource("")).getPath(), relativePath);
        try {
            Files.createDirectories(targetFilePath.getParent());
            Files.writeString(targetFilePath, content, StandardCharsets.UTF_8, Files.exists(targetFilePath)? StandardOpenOption.TRUNCATE_EXISTING : StandardOpenOption.CREATE);
            System.out.println("内容已成功写入文件。");
        } catch (IOException e) {
            System.out.println("写入文件时出错：" + e.getMessage());
        }
    }
}
