package com.carolinabartoli.produto_ms_1.configuration;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RabbitMQConfigTest {

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.username}")
    private String username;

    @Value("${rabbitmq.password}")
    private String password;

    @InjectMocks
    private RabbitMQConfig rabbitMQConfig;

    @Test
    public void testAmqpTemplate() {
        // Cenário
        ConnectionFactory connectionFactory = rabbitMQConfig.connectionFactory();

        // Ação
        AmqpTemplate amqpTemplate = rabbitMQConfig.amqpTemplate();

        // Verificação
        assertNotNull(amqpTemplate);
    }

    @Test
    public void testQueue() {
        // Cenário

        // Ação
        Queue queue = rabbitMQConfig.queue();

        // Verificação
        assertNotNull(queue);
        assertEquals("produto-criado", queue.getName());
        assertTrue(queue.isDurable());
    }
}