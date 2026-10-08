package ua.pp.darknsoft.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api")
public class StreamController {
    private final ChatClient chatClient;

    public StreamController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public Flux<String> stream(@RequestParam("message") String message) {
        return chatClient.prompt()
                .options(OllamaChatOptions.builder().model("llama3.2").numCtx(2560))
                .user(message).stream().content();
    }
}
