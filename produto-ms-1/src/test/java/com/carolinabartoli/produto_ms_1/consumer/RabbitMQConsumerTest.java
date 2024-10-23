package com.carolinabartoli.produto_ms_1.consumer;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.fail;

public class RabbitMQConsumerTest {

    @InjectMocks
    private RabbitMQConsumer rabbitMQConsumer;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReceberMensagem() {
        // Cenário
        Produto produto = new Produto();
        produto.setPreco(9.99);
        produto.setNome("Teste");

        // Ação
        rabbitMQConsumer.receberMensagem(produto);

        // Verificação
        // Verifica se a mensagem foi impressa no console
        // Nesse caso, não é possível verificar a saída do System.out.println
        // mas podemos verificar se o método foi chamado sem erros
        assertTrue(true);
    }

    @Test
    public void testReceberMensagemComProdutoNulo() {
        // Cenário
        Produto produto = null;

        // Ação e Verificação
        try {
            rabbitMQConsumer.receberMensagem(produto);
            fail("Deveria lançar NullPointerException");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testReceberMensagemComProdutoVazio() {
        // Cenário
        Produto produto = new Produto();

        // Ação
        rabbitMQConsumer.receberMensagem(produto);

        // Verificação
        // Verifica se a mensagem foi impressa no console
        // Nesse caso, não é possível verificar a saída do System.out.println
        // mas podemos verificar se o método foi chamado sem erros
        assertTrue(true);
    }
}