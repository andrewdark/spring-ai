package ua.pp.darknsoft.openai.rag;

import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.rag.Query;
import org.springframework.ai.rag.postretrieval.document.DocumentPostProcessor;

import java.util.List;

public class PIIMaskingDocumentPostProcessor implements DocumentPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PIIMaskingDocumentPostProcessor.class);

    private PIIMaskingDocumentPostProcessor() {
    }

    public static PIIMaskingDocumentPostProcessor builder() {
        return new PIIMaskingDocumentPostProcessor();
    }

    @NullMarked
    @Override
    public List<Document> process(Query query, List<Document> documents) {
        logger.debug("Masking sensitive information in documents for query: {}", query.text());
        return List.of();
    }
}
