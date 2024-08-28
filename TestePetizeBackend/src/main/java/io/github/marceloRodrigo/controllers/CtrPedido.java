package io.github.marceloRodrigo.controllers;

import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.repositorio.RepPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class CtrPedido {

    @Autowired
    private RepPedido repPedido;

    @PutMapping("/alterarStatus")
    public String alterarStatusPedido(@RequestParam Long pedidoId) {

        Pedido pedido = repPedido.findById(pedidoId)
                .orElse(null);
        if (pedido == null) {
            return "Pedido não encontrado.";
        }

        System.out.println("ALTERANDO STAUS PEDIDO: " + pedidoId);

        pedido.setStatusPedido("Concluído");

        repPedido.save(pedido);

        return "Status do pedido alterado para 'Concluído'.";
    }
}
