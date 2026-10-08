package ua.pp.darknsoft.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatMemoryChatClientConfig {

    @Bean("chatMemoryChatClient")
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        Advisor loggerAdvisor = new SimpleLoggerAdvisor();

        return chatClientBuilder
                .defaultAdvisors(List.of(loggerAdvisor))
                .build();
    }
}
