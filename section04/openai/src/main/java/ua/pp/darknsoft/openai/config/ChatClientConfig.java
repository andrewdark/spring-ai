package ua.pp.darknsoft.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.pp.darknsoft.openai.advisors.TokenUsageAuditAdvisor;

import java.util.List;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        var options = OllamaChatOptions.builder().model("llama3.2").temperature(0.8);

        return chatClientBuilder
                .defaultOptions(options)
                .defaultSystem("""
                        You are an internal HR assistant. Your role is to help\s
                        employees with questions related to HR policies, such as\s
                        leave policies, working hours, benefits, and code of conduct.
                        If a user asks for help with anything outside of these topics,\s
                        kindly inform them that you can only assist with queries related to\s
                        HR policies.
                        """)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor(),
                        new TokenUsageAuditAdvisor()))
                .defaultUser("How can you help me ?")
                .build();
    }
}
