package io.github.marceloRodrigo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CtrRequestsProduto {

    @Autowired CtrCadastrarProduto ctrCadastrarProduto;

    @GetMapping("/statusBuscaProdutos")
    public String statusBuscaProdutos(){
        return ctrCadastrarProduto.getProdutos() != null ? "{\"status\":\"pronto\"}" : "{\"status\":\"false\"}";
    }

    @GetMapping("/getProdutos")
    public String getProdutos(){
        ObjectMapper objectMapper = new ObjectMapper();
        String retorno;
        try {
            return objectMapper.writeValueAsString(ctrCadastrarProduto.getProdutos());
        } catch (JsonProcessingException e) {
            retorno = "ERRO: "+ e.getMessage();
            System.err.println(retorno);
        }

        return retorno;
    }

}
