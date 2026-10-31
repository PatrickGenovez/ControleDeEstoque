package service;

import java.math.BigDecimal;
import java.util.List;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoService {

   private ProdutoRepository produtoRepository;

   // Construtor
   public ProdutoService(ProdutoRepository produtoRepository) {
      this.produtoRepository = produtoRepository;
   }
   
   public boolean cadastrarProduto(Produto produto) {
      if (produto == null || produto.getNomeProduto() == null || produto.getNomeProduto().isEmpty()) {
         System.out.println("Erro, Tente novamente!");
         return false;
      }

      if(produtoRepository.buscarProduto(produto.getNomeProduto()) != null) {
         System.out.println("Erro: já existe um produto cadastrado com esse nome!");
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


   public List<Produto> listarProdutos(){
      if(produtoRepository.getProdutos().isEmpty()){
         System.out.println("Lista vazia!");
      } 
      return produtoRepository.getProdutos();
   }


   public Produto buscarPorNome(String nome) {
   //1º Validação
   if (nome == null || nome.isBlank()) {
      System.out.println("Erro, insira um dado!");
      return null;
   }
   
   // Ele irá buscar no repo
   Produto produto = produtoRepository.buscarProduto(nome);

   //2º validação 
   if (produto == null){
      System.out.println("Produto não encontrado!");
      return null;
   } 
   // Após passar pelas duas validações ele retorna!
   return produto;
}

public boolean editarNovoProduto(Produto produto, BigDecimal novoPreco, int novaQtd){

      if (produto == null){
         System.out.println("Erro!");
         return false;
      }


      if (novoPreco == null || novoPreco.compareTo(BigDecimal.ZERO) <= 0){
         System.out.println("Erro: o preço deve ser maior que zero!");
         return false;
      }

      if (novaQtd < 0){
         System.out.println("Erro: a quantidade não pode ser negativa! ");
         return false;
      }
      
      produto.setPreco(novoPreco);     
      produto.setQtdEstoque(novaQtd);     

      System.out.println("Produto atualizado com sucesso!");
      return true;
   }

   public boolean removerProduto(Produto produto) {
      if(produto == null) {
         System.out.println("Erro: produto inexistente!");
         return false;
      }
      produtoRepository.removerProduto(produto);
      System.out.println("Produto removido com sucesso!");
      return true;
   }
}
