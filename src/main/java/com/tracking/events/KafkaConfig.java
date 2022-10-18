package com.tracking.events;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaConfig {
    @Value("${server.kafka}")
    private String SERVER_URL;

    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_URL);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //configProps.put(ProducerConfig.ACKS_CONFIG)
        //configProps.put(ProducerConfig.BATCH_SIZE_CONFIG)
        //LINGER_MS_CONFIG,REQUEST_TIMEOUT_MS_CONFIG,MAX_REQUEST_SIZE_CONFIG,MAX_BLOCK_MS_CONFIG
        //COMPRESSION_TYPE_CONFIG, MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION
        //PARTITIONER_CLASS_CONFIG
        //ENABLE_IDEMPOTENCE_CONFIG, TRANSACTION_TIMEOUT_CONFIG, TRANSACTIONAL_ID_CONFIG

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_URL);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "baeldung");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        /**
         * max.poll.interval.ms
         * session.timeout.ms
         * heartbeat.interval.ms
         * bootstrap.servers
         * enable.auto.commit.
         * auto.commit.interval.ms
         * auto.offset.reset - defaultValue: latest, {latest, earliest, none}
         * fetch.min.bytes
         * fetch.max.bytes
         *
         * retry.backoff.ms
         * reconnect.backoff.ms
         *
         * metrics.log.level
         * request.timeout.ms
         *
         * allow.auto.create.topics - defaultValue: true
         * Isolation.level
         *
         * partition.assignment.strategy
         * - Assigns partitions
         * - Guarantees an assignmen
         * - Sticky Assignor
         */
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @SuppressWarnings("SpringConfigurationProxyMethods")
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
