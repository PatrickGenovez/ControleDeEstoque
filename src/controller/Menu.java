package controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import model.Produto;
import repository.ProdutoRepository;
import service.ProdutoService;

public class Menu {
    Scanner scan = new Scanner(System.in);

    private ProdutoRepository produtoRepository = new ProdutoRepository();
    private ProdutoService produtoService = new ProdutoService(produtoRepository);


    public void menuIniciar(){
        int operacao = 0;

        do {

            System.out.println("=== Controle de Estoque");
            System.out.println("[ 1 ] - Cadastrar produto");
            System.out.println("[ 2 ] - Listar produto");
            System.out.println("[ 3 ] - Pesquisar produto pelo nome");
            System.out.println("[ 4 ] - Editar protudo");
            System.out.println("[ 5 ] - Remover produto");
            System.out.println("[ 0 ] - Sair");
            System.out.print("Escolha a operação: ");
            operacao = scan.nextInt();
            scan.nextLine();

            switch (operacao) {
                case 1:
                    menuCadastro();
                    break;
                case 2:
                    menuListar();
                    break;
                case 3:
                    menuPesquisar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Tente novamente, inválido!");
                    break;
            }
        } while (operacao != 0) ; {
            System.out.println("Finalizando...");
        }
    }


    public void menuCadastro(){
        System.out.println("=== Cadastrar produto ===");

        System.out.print("Nome do produto: ");
        String nomeProduto = scan.nextLine();

        System.out.print("Preço do produto: ");
        BigDecimal preco =  scan.nextBigDecimal();

        System.out.print("Quantidade em estoque: ");
        int qtdEstoque = scan.nextInt();
        scan.nextLine();

        Produto produto = new Produto(nomeProduto, preco, qtdEstoque);

        produtoService.cadastrarProduto(produto);

    }

    public void menuListar(){
        System.out.println("=== Listar Produtos ===");

        for (Produto p : produtoService.listarProdutos()) {
            System.out.println("Nome: " + p.getNomeProduto());
            System.out.println("Preço: " + p.getPreco());   
            System.out.println("Quantidade: " + p.getQtdEstoque());
            System.out.println("=================================");
        }
    }

    public void menuPesquisar(){
        System.out.println("=== Pesquisar Produto ===");
        System.out.print("Digite o nome do produto que queira pesquisar: ");
        String nomePesquisa = scan.nextLine();

        Produto produto =  produtoService.buscarPorNome(nomePesquisa);

        if(produto != null) {
            System.out.println("====================");
            System.out.println("Produto encontrado!");
            System.out.println("====================");
            System.out.println("Nome: " + produto.getNomeProduto());
            System.out.println("Peço: " + produto.getPreco());
            System.out.println("Quantidade em estoque: " + produto.getQtdEstoque());
            System.out.println("====================");
        }
    }

    public void menuEditar(){

    }

    public void menuRemover(){
        
    }
}
