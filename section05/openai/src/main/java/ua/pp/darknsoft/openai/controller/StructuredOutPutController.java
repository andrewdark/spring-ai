package ua.pp.darknsoft.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.pp.darknsoft.openai.model.CountryCities;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StructuredOutPutController {
    private final ChatClient chatClient;

    public StructuredOutPutController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @GetMapping(value = "/chat-bean", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<CountryCities> chatBean(@RequestParam("message") String message) {
        CountryCities countryCities = chatClient
                .prompt()
                .user(message)
                .call().entity(CountryCities.class);
        return ResponseEntity.ok(countryCities);
    }

    @GetMapping("/chat-list")
    public ResponseEntity<List<String>> chatList(@RequestParam("message") String message) {
        List<String> countryCities = chatClient
                .prompt()
                .options(OllamaChatOptions.builder().model("llama3.2").numCtx(2048))
                .user(message)
                .call().entity(new ListOutputConverter());
        return ResponseEntity.ok(countryCities);
    }

    @GetMapping("/chat-map")
    public ResponseEntity<Map<String, Object>> chatMap(@RequestParam("message") String message) {
        Map<String, Object> countryCities = chatClient
                .prompt()
                .user(message)
                .call().entity(new MapOutputConverter());
        return ResponseEntity.ok(countryCities);
    }

    @GetMapping("/chat-bean-list")
    public ResponseEntity<List<CountryCities>> chatBeanList(@RequestParam("message") String message) {
        List<CountryCities> countryCities = chatClient
                .prompt()
                .options(OllamaChatOptions.builder().model("llama3.2").numCtx(2048))
                .user(message)
                .call().entity(new ParameterizedTypeReference<List<CountryCities>>() {
                });
        return ResponseEntity.ok(countryCities);
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public Flux<String> stream(@RequestParam("message") String message) {
        return chatClient.prompt()
                .options(OllamaChatOptions.builder().model("llama3.2").numCtx(2560))
                .user(message).stream().content();
    }
}
