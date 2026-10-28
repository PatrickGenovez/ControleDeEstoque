package service;

import java.math.BigDecimal;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoService {

   private ProdutoRepository produtoRepository;

   // Construtor
   public ProdutoService(ProdutoRepository produtoRepository) {
      this.produtoRepository = produtoRepository;
   }

   public Produto buscarPorNome(String nome) {
      if (nome == null || nome.trim().isEmpty()) {
         System.out.println("Erro, insira um dado!");
         return null;
      }
      return produtoRepository.buscarProduto(nome);
   }

   
   public boolean cadastrarProduto(Produto produto) {
      if (produto == null || produto.getNomeProduto() == null || produto.getNomeProduto().isEmpty()) {
         System.out.println("Erro, Tente novamente!");
         return false;
      }

      if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) < 0) {
         System.out.println("Erro: O preço do produto deve ser maior que zero!");
         return false;
      }

      if (produto.getQtdEstoque() < 0) {
         System.out.println("Erro: a quantidade em estoque não pode ser negativa!");
         return false;
      }

      produtoRepository.salvarDados(produto);
      System.out.println("Produto Cadastrado com sucesso!");
      return true;
   }

}
