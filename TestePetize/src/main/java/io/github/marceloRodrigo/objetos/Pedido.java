package io.github.marceloRodrigo.objetos;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Pedido {

    private int pedidoId;

    private Timestamp dataPedido;

    private int quantidadeItens;

    private String statusPedido;

    private ArrayList<Produto> produtos;


    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Timestamp getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Timestamp dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setPedidoProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

}
