package model;

import java.math.BigDecimal;


public class Produto {
    private String nomeProduto;
    private BigDecimal preco;
    private int qtdEstoque;

    // Construtores

    public Produto() {

    }

    public Produto(String nomeProduto, BigDecimal preco, int qtdEstoque) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    // Getters e Setters
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    
    
}
