package ua.pp.darknsoft.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Note: This is a simple prompt stuffing approach. (Short instruction)
 * In other cases we have to use Retrieval augmented generation (RAG) approach which is more suitable for complex prompts.
 *
 * RAG (Retrieval Augmented Generation) is a technique that combines the search capabilities of a search engine with the generation capabilities of a language model.
 * It allows you to generate high-quality text by leveraging the knowledge and context available in a large corpus of text.
 * The basic idea is to use a search engine to find relevant documents from the corpus, and then use a language model to augment and complete the retrieved text.
 */
@RestController
@RequestMapping("/api")
public class PromptStuffingController {
    private final ChatClient chatClient;

    public PromptStuffingController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Value("classpath:/promptTemplates/systemPromptTemplate.st")
    Resource systemPromptTemplate;

    @GetMapping("/prompt-stuffing")
    public String promptStuffing(@RequestParam("message") String message) {
        return "DUMMY ANSWER";
    }
}
