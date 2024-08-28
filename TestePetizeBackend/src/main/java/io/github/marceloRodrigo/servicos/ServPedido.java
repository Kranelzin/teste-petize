package io.github.marceloRodrigo.servicos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.objetos.Produto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServPedido {
    @Autowired
    private AmqpTemplate amqpTemplate;

    ObjectMapper objectMapper = new ObjectMapper();


    public void respostaBuscarPedidos(List<Pedido> pedidos) throws JsonProcessingException {
        for (Pedido pedido : pedidos) {
            pedido.getProdutos().size();
        }

        System.out.println("========ENVIANDO RESPOSTA==========");
        amqpTemplate.convertAndSend(
                "resposta_buscar_pedido_exchange",
                "resposta.buscar.pedido.routing.key",
                objectMapper.writeValueAsString(pedidos)
        );
    }

}
