package io.github.marceloRodrigo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CtrRequestsPedido {

    @Autowired CtrCadastrarPedido ctrCadastrarPedido;

    @GetMapping("/verificarStatusPedido")
    public String statusBuscaPedidos(){
        return ctrCadastrarPedido.getPedidos() != null ? "{\"status\":\"pronto\"}" : "{\"status\":\"false\"}";
    }

    @GetMapping("/getPedidos")
    public String getPedidos(){
        ObjectMapper objectMapper = new ObjectMapper();
        String retorno;
        try {
            return objectMapper.writeValueAsString(ctrCadastrarPedido.getPedidos());
        } catch (JsonProcessingException e) {
            retorno = "ERRO: "+ e.getMessage();
            System.err.println(retorno);
        }

        return retorno;
    }

}
