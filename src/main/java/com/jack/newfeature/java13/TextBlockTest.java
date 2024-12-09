package com.jack.newfeature.java13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack.common.User;

public class TextBlockTest {
    private String testJson = """
            {
                "name": "Jack",
                "age": 18
            }
            """;
    public static void main(String[] args) throws Exception {
        System.out.println(new TextBlockTest().testJson);
        User user = new ObjectMapper().readValue(new TextBlockTest().testJson, User.class);
        System.out.println(user.toString());
    }
}