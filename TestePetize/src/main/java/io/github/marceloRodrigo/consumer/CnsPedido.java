package io.github.marceloRodrigo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.controllers.CtrCadastrarPedido;
import io.github.marceloRodrigo.controllers.CtrCadastrarProduto;
import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.objetos.Produto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CnsPedido {

    @Autowired
    CtrCadastrarPedido ctrCadastrarPedido;

    @RabbitListener(queues = {"resposta_buscar_pedido_queue"})
    public void respostaBuscarListaPedidos (@Payload String json) {
        System.out.println("========PEDIDOS=========");
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            pedidos = mapper.readValue(json, new TypeReference<ArrayList<Pedido>>(){});
        } catch (JsonProcessingException e) {
            System.err.println("ERRO: " + e.getMessage());
        }

        ctrCadastrarPedido.atualizarPedidos(pedidos);
    }

}
