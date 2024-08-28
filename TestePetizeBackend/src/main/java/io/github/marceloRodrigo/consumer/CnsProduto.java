package io.github.marceloRodrigo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.objetos.Produto;
import io.github.marceloRodrigo.repositorio.RepProduto;
import io.github.marceloRodrigo.servicos.ServGeral;
import io.github.marceloRodrigo.servicos.ServProduto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class CnsProduto {

    @Autowired
    private ServProduto servProduto;
    @Autowired
    private ServGeral servGeral;

    @Autowired
    private RepProduto repProduto;

    @RabbitListener(queues = {"buscar_produto_queue"})
    public void buscarProdutos(@Payload String json) {

        try {
            System.out.println("=======BUSCANDO PRODUTOS======");
            servProduto.respostaBuscarProdutos(repProduto.findAll());
        }catch (JsonProcessingException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    @RabbitListener(queues = {"cadastrar_produto_queue"})
    public void cadastrarProduto(@Payload String json) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Produto produto = mapper.readValue(json, Produto.class);

            repProduto.save(produto);

            servGeral.gerarRespostaSucesso("Produto cadastrado com sucesso, produtoId: " + produto.getId());

        } catch (JsonProcessingException e) {
            servGeral.gerarRespostaErro("Erro: " + e.getMessage());
        }
    }

    @RabbitListener(queues = {"deletar_produto_queue"})
    public void deletarProduto(@Payload String json) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Long id = mapper.readValue(json, Long.class);

            if(repProduto.existsById(id))
                repProduto.deleteById(id);

            servGeral.gerarRespostaSucesso("Produto deletado com sucesso, produtoId: " + id);

        } catch (JsonProcessingException e) {
            servGeral.gerarRespostaErro("Erro: " + e.getMessage());
        }
    }
}
