package repository;

import java.util.ArrayList;
import java.util.List;

import model.Produto;
import service.ProdutoService;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    // Getters e Setters
    public void salvarDados(Produto produto){
        produtos.add(produto);
    }

    public Produto buscarProduto(String nome){
        for(Produto p : produtos){
            if(p.getNomeProduto().trim().equalsIgnoreCase(nome.trim())){
                return p;
             }
        }
        return null;
    }

    public boolean removerProduto(Produto produto) {
        return produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }    

    
    
}
