package io.github.marceloRodrigo.servicos;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.marceloRodrigo.objetos.Produto;
import io.github.marceloRodrigo.producer.PrdCadastrarProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServProduto {

    @Autowired
    private PrdCadastrarProduto prdCadastrarProduto;

    public String cadastrarProduto(Produto produto) {

        try {
            prdCadastrarProduto.cadastrarProduto(produto);
        } catch (JsonProcessingException e) {
           return "ERRO: " + e.getMessage();
        }

        return "Aguardando cadastro de produto";
    }

    public String buscarProdutos() {

        prdCadastrarProduto.buscarProdutos();

        return "Aguardando retorno de produto";
    }

    public String deletarProduto(Long id) {
        try {
            prdCadastrarProduto.deletarProduto(id);
        } catch (JsonProcessingException e) {
            return "ERRO: " + e.getMessage();
        }

        return "Aguardando retorno de deletar produto";
    }
}
