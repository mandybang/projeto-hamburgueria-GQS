# language: pt
@hamburgueria
Funcionalidade: Pedidos na hamburgueria Peppa Lanches
  Para realizar pedidos corretos
  Como cliente
  Eu quero saber se o item pode ser pedido, o valor total e o tempo estimado

  Contexto:
    Dado que o cardápio contém os itens:
      | item         | preco |
      | x-bacon      | 25.00 |
      | x-salada     | 22.00 |
      | batata frita | 12.00 |

  @feliz
  Cenário: Pedido simples de item existente
    Quando eu solicitar o item "x-bacon" na quantidade 2
    Então o total do pedido deve ser 50.00

  @inexistente
  Cenário: Pedido de item inexistente
    Quando eu solicitar o item "milkshake" na quantidade 1
    Então deve ocorrer o erro "Item indisponível no cardápio"

  @quantidade
  Cenário: Pedido com quantidade inválida
    Quando eu solicitar o item "x-salada" na quantidade 0
    Então deve ocorrer o erro "Quantidade inválida"

  @desconto
  Cenário: Pedido com desconto de 10 por cento
    Quando eu solicitar o item "batata frita" na quantidade 3 com desconto
    Então o total do pedido com desconto deve ser 32.40

  @sla
  Cenário: Calcular tempo estimado de preparo
    Quando eu solicitar o item "x-salada" na quantidade 4
    Então o tempo estimado deve ser 16
