package com.jack.newfeature.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourceTest {
    public static void main(String[] args) {
        // it declared three resources, and they will be closed automatically
        try (
                FileReader fr = new FileReader("~/IdeaProjects/Java21Demo/src/main/resources/file1.txt");
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter("~/IdeaProjects/Java21Demo/src/main/resources/file2.txt")
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
