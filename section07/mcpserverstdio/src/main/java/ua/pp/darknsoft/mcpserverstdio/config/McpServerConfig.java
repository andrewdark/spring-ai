package ua.pp.darknsoft.mcpserverstdio.config;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.pp.darknsoft.mcpserverstdio.tool.HelpDeskTools;

import java.util.List;

@Configuration
public class McpServerConfig {
    /*
     * @Bean потрібен, якщо використовуємо @Tool у класі HelpDeskTools
     * @McpTool, не потрібно вручну створювати бін через ToolCallbacks.from(...).
     * Стартер spring-ai-starter-mcp-server автоматично сканує всі компоненти Spring (@Component, @Service) та самостійно реєструє методи, помічені @McpTool, як інструменти для протоколу MCP.
     */

//    @Bean
//    public List<ToolCallback> toolCallbacks(HelpDeskTools helpDeskTools) {
//        return List.of(ToolCallbacks.from(helpDeskTools));
//    }
}
