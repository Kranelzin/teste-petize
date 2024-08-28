package io.github.marceloRodrigo.servicos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.objetos.Produto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServProduto {
    @Autowired
    private AmqpTemplate amqpTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    public void respostaBuscarProdutos(List<Produto> produtos) throws JsonProcessingException {
        System.out.println("========ENVIANDO RESPOSTA==========");
        amqpTemplate.convertAndSend(
            "resposta_buscar_produto_exchange",
            "resposta.buscar.produto.routing.key",
            objectMapper.writeValueAsString(produtos)
        );
    }


}
