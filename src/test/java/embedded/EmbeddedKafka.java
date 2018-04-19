package embedded;

import config.TestConfig;
import org.springframework.kafka.test.rule.KafkaEmbedded;

/**
 * singleton instance of EmbeddedKafka
 */
public class EmbeddedKafka {

    private static final KafkaEmbedded INSTANCE = getEmbeddedKafka();

    private static KafkaEmbedded getEmbeddedKafka() {
        KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TestConfig.Topic.getTopicNames());
        //embeddedKafka.setKafkaPorts(KAFKA_PORT);
        return embeddedKafka;
    }

    public static KafkaEmbedded getInstance() {
        return INSTANCE;
    }
}
