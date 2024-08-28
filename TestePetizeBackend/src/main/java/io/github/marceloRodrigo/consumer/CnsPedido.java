package io.github.marceloRodrigo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.objetos.Produto;
import io.github.marceloRodrigo.repositorio.RepPedido;
import io.github.marceloRodrigo.repositorio.RepProduto;
import io.github.marceloRodrigo.servicos.ServGeral;
import io.github.marceloRodrigo.servicos.ServPedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CnsPedido {

    @Autowired
    private ServGeral servGeral;
    @Autowired
    private ServPedido servPedido;

    @Autowired
    private RepPedido repPedido;

    @Autowired
    private RepProduto repProduto;

    @RabbitListener(queues = {"cadastrar_pedido_queue"})
    public void cadastrarPedido(@Payload String json) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("JSON: " + json);
            ArrayList<Produto> produtos = new ArrayList<>();
            produtos = mapper.readValue(json, new TypeReference<ArrayList<Produto>>(){});

            Pedido pedido = new Pedido();
            pedido.setProdutos(produtos);
            pedido.setDataPedido(new Timestamp(new Date().getTime()));
            pedido.setStatusPedido("Pendente");
            pedido.setQuantidadeItens(produtos.size());

            for (Produto produto : pedido.getProdutos()) {
                Produto produtoSalvo = repProduto.save(produto);
                produto.setId(produtoSalvo.getId());
            }

            repPedido.save(pedido);

            servGeral.gerarRespostaSucesso("Pedido cadastrado com sucesso, pedidoId: " + pedido.getPedidoId());

        } catch (JsonProcessingException e) {
            servGeral.gerarRespostaErro("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = {"buscar_pedido_queue"})
    public void buscarPedidos(@Payload String json) {

        try {
            System.out.println("=======BUSCANDO PEDIDOS======");
            List<Pedido> pedidos = repPedido.findAll();

            System.out.println("Número de pedidos encontrados: " + pedidos.size());

            for (Pedido pedido : pedidos) {
                pedido.getProdutos().size();
            }

            servPedido.respostaBuscarPedidos(pedidos);

        } catch (Exception e) {
            System.err.println("Erro ao buscar pedidos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
