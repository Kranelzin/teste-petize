package io.github.marceloRodrigo.controllers;

import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.objetos.Produto;
import io.github.marceloRodrigo.servicos.ServProduto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@SessionAttributes("produtos")

public class CtrCadastrarProduto {

    private ArrayList<Produto> produtos = null;

    @Autowired
    ServProduto servProduto;

    @PostMapping("/cadastrarProduto")
    public ModelAndView cadastrarProduto(Produto produto) {
        System.out.println(servProduto.cadastrarProduto(produto));
        return abrirCadastroProdutos();
    }

    @GetMapping("/formularioProduto")
    public ModelAndView abrirCadastroProdutos(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastrar-produto");
        modelAndView.addObject("produto", new Produto());
        this.produtos = null;
        servProduto.buscarProdutos();

        return modelAndView;
    }

    public void atualizarProdutos(ArrayList<Produto> produtos){
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    @DeleteMapping("/deletarProduto/{id}")
    public ModelAndView deletarProduto(@PathVariable("id") Long id) {
        System.out.println(servProduto.deletarProduto(id));
        return abrirCadastroProdutos();
    }
}
