package ua.pp.darknsoft.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ChatMemoryController {

    private final ChatClient chatClient;

    public ChatMemoryController(@Qualifier("chatMemoryChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat-memory")
    public ResponseEntity<String> chatMemory(@RequestHeader("username") String username,
                                             @RequestParam("message") String message) {
        return ResponseEntity.ok(chatClient.prompt()
                .options(OllamaChatOptions.builder().model("llama3.2").numCtx(2560))
                .user(message)
                .call().entity(String.class));
    }
}
