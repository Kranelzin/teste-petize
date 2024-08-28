package io.github.marceloRodrigo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.controllers.CtrCadastrarProduto;
import io.github.marceloRodrigo.objetos.Produto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CnsProduto {

    @Autowired
    CtrCadastrarProduto ctrCadastrarProduto;

    @RabbitListener(queues = {"resposta_buscar_produto_queue"})
    public void respostaBuscarListaProdutos (@Payload String json) {
        System.out.println("========PRODUTOS=========");
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            produtos = mapper.readValue(json, new TypeReference<ArrayList<Produto>>(){});
        } catch (JsonProcessingException e) {
            System.err.println("ERRO: " + e.getMessage());
        }

        ctrCadastrarProduto.atualizarProdutos(produtos);
    }

}
