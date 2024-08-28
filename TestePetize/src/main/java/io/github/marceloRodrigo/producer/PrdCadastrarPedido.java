package io.github.marceloRodrigo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrdCadastrarPedido {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void cadastrarPedido (String json) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "cadastrar_pedido_exchange",
                "cadastrar.pedido.routing.key",
                json
        );
    }

    public void buscarPedidos() {
        amqpTemplate.convertAndSend(
                "buscar_pedido_exchange",
                "buscar.pedido.routing.key",
                "buscar_pedidos"
        );
    }
}
