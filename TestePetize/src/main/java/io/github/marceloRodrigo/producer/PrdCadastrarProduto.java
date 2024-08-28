package io.github.marceloRodrigo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.objetos.Produto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrdCadastrarProduto {
    @Autowired
    private AmqpTemplate amqpTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    public void cadastrarProduto (Produto produto) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "cadastrar_produto_exchange",
                "cadastrar.produto.routing.key",
                objectMapper.writeValueAsString(produto)
        );
    }

    public void buscarProdutos() {
        amqpTemplate.convertAndSend(
                "buscar_produto_exchange",
                "buscar.produto.routing.key",
                "buscar_produtos"
        );
    }

    public void deletarProduto(Long id) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "deletar_produto_exchange",
                "deletar.produto.routing.key",
                objectMapper.writeValueAsString(id)

        );
    }
}
