# projeto-hamburgueria-GQS
Projeto acadêmico de BDD usando Java, Maven, JUnit e Cucumber. Implementa cenários de pedidos da hamburgueria Peppa Lanches, validando itens, cálculos, descontos, erros e tempo estimado. Inclui feature, steps em PT-BR e runner configurado.

---

## Objetivo  
Implementar cenários de teste para pedidos da hamburgueria Peppa Lanches, garantindo:  
- Validação correta de itens do cardápio  
- Cálculo do total de pedidos  
- Tratamento de erros  
- Cálculo de tempo estimado  
- Aplicação de desconto  

---

## 🗂️ Estrutura do Projeto (Maven)

projetohamburgueria
├── pom.xml
├── README.md
├── .gitignore
└── src
    ├── main
    │ └── java
    │       └── peppa.hamburgueria
    │           ├── CardapioService.java
    │           └── PedidoService.java
    └── test
        ├── java
        │     ├── steps
        │     |   └── PedidoSteps.java
        │     └── runner
        |            └── RunnerTest.java
        └── resources
                └── features
                        └── pedidos.feature

## 🧪 Tecnologias Utilizadas  
- **Java 21**  
- **Cucumber JVM 7.x**  
- **JUnit 5 / Platform Suite**  
- **Gherkin (PT-BR)**  
- **Maven**

---

## 📚 Como rodar os testes  
1. Abrir o projeto em qualquer IDE (IntelliJ, Eclipse, VSCode).  
2. Executar a classe `RunnerTest`.  
3. O relatório HTML será gerado em: target/cucumber-report.html 

---

## 🧩 Cenários implementados  
✔ Pedido simples  
✔ Item inexistente  
✔ Quantidade inválida  
✔ Pedido com desconto  
✔ Cálculo de tempo estimado  

---

## 👥 Equipe  
- Amanda Fonseca - RA: 42321095
- Felipe Bastos - RA: 42321681
- Gabriella Oliveira Nogueira - RA: 42321688  