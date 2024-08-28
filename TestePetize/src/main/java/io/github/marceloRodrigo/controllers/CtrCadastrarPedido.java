package io.github.marceloRodrigo.controllers;

import io.github.marceloRodrigo.objetos.Pedido;
import io.github.marceloRodrigo.servicos.ServPedido;
import io.github.marceloRodrigo.servicos.ServProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@SessionAttributes("pedido")
public class CtrCadastrarPedido {

    private ArrayList<Pedido> pedidos = null;

    @Autowired
    private ServPedido servPedido;
    @Autowired
    ServProduto servProduto;

    @GetMapping("/formularioPedido")
    public ModelAndView abrirCadastrarPedido() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastrar-pedido");
        modelAndView.addObject("pedido", new Pedido());
        servProduto.buscarProdutos();

        return modelAndView;
    }

    @GetMapping("/verPedidos")
    public ModelAndView verPedidos() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pedidos");
        modelAndView.addObject("pedido", new Pedido());
        System.out.println(servPedido.buscarPedidos());

        return modelAndView;
    }

    @PostMapping("/cadastrarPedido")
    public ModelAndView finalizarPedido (@RequestBody String json){
        System.out.println("PEDIDO: " + json);
        System.out.println(servPedido.cadastrarPedido(json));
        return abrirCadastrarPedido();
    }

    public void atualizarPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

}
