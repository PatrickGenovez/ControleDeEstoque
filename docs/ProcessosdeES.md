Sistema de Controle de Estoque (MiniMundo)

O sistema deve permitir cadastrar um produto, logo após irá informar o nome do produto, o preço e a quantidade em estoque, após tudo isso ser preenchido o sistema deve validar e aprovar o cadastro. Com o cadastro completo o usuário poderá ver todos os itens que cadastrou, podendo pesquisar pelo nome do produto cadastrado que será retornado o nome, o valor e quantidade em estoque.

Requisitos Funcionais 
RF01 - Cadastrar produto 
RF02 - Listar produtos 
RF03 - Pesquisar produto pelo nome
RF04 - Editar produto 
RF05 - Remover Produto

Requisitos não Funcionais
RNF01 - O sistema deve ser executado via interfface de linha de comando 
RNF02 - O sistema deve ser rápido e responsivo
RNF03 - O sistema deve ser seguro baseado na LGPD
RNF04 - O sistema deve ser desenvolvido na linguagem java (Versão 17 ou superior)

Regras de Negócios
RN01 - Só irá aprovar o cadastro se todas as informações forem definidas
RN02 - o preço do produto deve ser maior que zero
RN03 - O numero de estoque deve ser maior ou igual a 0
RN04 - O usuário não pode remover um item que não existe 
RN05 - Caso o produto pesquisado não exista, o sistema deve retornar uma mensagem
informando que nenhum produto foi encontrado sem encerrar a execução.
RN06 - O usuário não pode editar um item que não existe
RN07 - Não deve ser permitido cadastar dois produtos com o mesmo nome (ou mesmo código/ID)

Entidade Atributos

Produto 
- id : int(PK) 
- nome : String 
- preco : BigDecimal
- QtdEmEstoque : int

ProdutoRepository
+ cadastarProduto()
+ listarProduto()
+ pesquisarPorNome()
+ editarProduto()
+ removerProduto()
