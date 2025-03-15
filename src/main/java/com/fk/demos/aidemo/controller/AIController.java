package com.fk.demos.aidemo.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ai")
@RequiredArgsConstructor
public class AIController {

    private final ChatModel chatModel;

//    public AIController(@NonNull ChatModel chatModel) {
//        this.chatModel = chatModel;
//    }

    @PostMapping(consumes = "text/plain")
    public String askQuestions(@RequestBody String question){
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        var response = chatModel.call(prompt);
        return response.getResult().getOutput().getText();

    }

}
