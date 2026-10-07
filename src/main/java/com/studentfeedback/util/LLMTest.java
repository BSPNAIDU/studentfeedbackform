package com.studentfeedback.util;

import com.studentfeedback.service.LLMService;

public class LLMTest {

    public static void main(String[] args) {

        try {
            LLMService llmService = new LLMService();

            String answer = llmService.ask(
                "Explain what a database is in two simple sentences."
            );

            System.out.println();
            System.out.println("========== AI RESPONSE ==========");
            System.out.println(answer);
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println();
            System.out.println("========== AI ERROR ==========");
            System.out.println(e.getMessage());
            System.out.println("==============================");

            e.printStackTrace();
        }
    }
}