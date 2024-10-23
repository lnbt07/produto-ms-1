package com.carolinabartoli.produto_ms_1.consumer;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "produto-criado")
    public void receberMensagem(Produto produto) {
        if(produto != null){
            System.out.println("Produto criado com sucesso: " + produto);
        } else {
            throw new NullPointerException();
        }
    }
}
