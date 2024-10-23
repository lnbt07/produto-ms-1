package com.carolinabartoli.produto_ms_1.service;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.AmqpTemplate;

import static org.mockito.Mockito.verify;

public class RabbitMQServiceTest {
    @Mock
    private AmqpTemplate amqpTemplate;

    @InjectMocks
    private RabbitMQService rabbitMQService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEnviarMensagem() {
        // Cenário
        Produto produto = new Produto();
        produto.setNome("teste");
        produto.setPreco(9.99);

        // Ação
        rabbitMQService.enviarMensagem(produto);

        // Verificação
        verify(amqpTemplate).convertAndSend("produto-criado", produto);
    }

    @Test
    public void testEnviarMensagemComProdutoVazio() {
        // Cenário
        Produto produto = new Produto();

        // Ação
        rabbitMQService.enviarMensagem(produto);

        // Verificação
        verify(amqpTemplate).convertAndSend("produto-criado", produto);
    }
}
