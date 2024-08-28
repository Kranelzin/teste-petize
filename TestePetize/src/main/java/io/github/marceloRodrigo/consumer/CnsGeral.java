package io.github.marceloRodrigo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CnsGeral {
    @RabbitListener(queues = {"resposta_sucesso_queue"})
    public void receberMensagemSucesso (@Payload String json) {
        System.out.println(json);
    }

    @RabbitListener(queues = {"resposta_erro_queue"})
    public void receberMensagemErro (@Payload String json) {
        System.err.println(json);
    }
}
