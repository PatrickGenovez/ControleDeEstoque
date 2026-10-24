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


    public List<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }    

    
    
}
