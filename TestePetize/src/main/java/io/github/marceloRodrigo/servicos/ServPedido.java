package io.github.marceloRodrigo.servicos;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.producer.PrdCadastrarPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServPedido {

    @Autowired
    private PrdCadastrarPedido prdCadastrarPedido;

    public String cadastrarPedido(String json) {
        try {
           prdCadastrarPedido.cadastrarPedido(json);
        } catch (JsonProcessingException e) {
            return "Erro: " + e.getMessage();
        }

        return "Aguardando cadastro de pedido";
    }

    public String buscarPedidos() {

        prdCadastrarPedido.buscarPedidos();

        return "Aguardando retorno de pedidos";
    }

}
