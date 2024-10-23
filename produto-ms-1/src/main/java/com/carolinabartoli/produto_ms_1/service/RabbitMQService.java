package com.carolinabartoli.produto_ms_1.service;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Princípio de Segregação de Interface (ISP):
// Esta classe agora tem apenas a responsabilidade de enviar mensagens para RabbitMQ
@Service
public class RabbitMQService {

    // Injeção de dependência (DIP):
    // Removemos a criação direta do template e passamos a receber por injeção
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMQService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void enviarMensagem(Produto produto) {
        // Enviar mensagem para RabbitMQ
        amqpTemplate.convertAndSend("produto-criado", produto);
    }
}