package steps;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import peppa.hamburgueria.CardapioService;
import peppa.hamburgueria.PedidoService;

public class PedidoSteps {

    private CardapioService cardapio;
    private PedidoService pedido;
    private double total;
    private int tempo;
    private Exception erro;

    // ... (Métodos Dado e Quando permanecem inalterados) ...

    @Dado("que o cardápio contém os itens:")
    public void que_o_cardapio_contem_os_itens(DataTable dataTable) {
        cardapio = new CardapioService();
        List<Map<String, String>> linhas = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> linha : linhas) {
            String item = linha.get("item");
            double preco = Double.parseDouble(linha.get("preco"));
            cardapio.cadastrarItem(item, preco);
        }
        pedido = new PedidoService(cardapio);
    }

    @Quando("eu solicitar o item {string} na quantidade {int}")
    public void eu_solicitar_o_item_na_quantidade(String item, int quantidade) {
        try {
            erro = null;
            total = pedido.calcularTotal(item, quantidade);
            tempo = pedido.calcularTempoEstimado(quantidade);
        } catch (Exception e) {
            erro = e;
        }
    }

    @Quando("eu solicitar o item {string} na quantidade {int} com desconto")
    public void eu_solicitar_o_item_na_quantidade_com_desconto(String item, int quantidade) {
        try {
            erro = null;
            double bruto = pedido.calcularTotal(item, quantidade);
            total = Math.round((bruto * 0.90) * 100.0) / 100.0;
        } catch (Exception e) {
            erro = e;
        }
    }

    // CORREÇÃO AQUI (Linha ~60)
    @Então("o total do pedido deve ser {double}")
    public void o_total_do_pedido_deve_ser(Double esperado) {
        Assertions.assertNull(erro, "Não era esperado erro, mas ocorreu: " + (erro != null ? erro.getMessage() : ""));
        // 1. Divide o esperado por 100.0 para converter de centavos para Reais.
        // 2. Usa 0.001 de delta para comparação de double.
        Assertions.assertEquals(esperado / 100.0, total, 0.001); 
    }

    @Então("deve ocorrer o erro {string}")
    public void deve_ocorrer_o_erro(String mensagemEsperada) {
        Assertions.assertNotNull(erro, "Era esperado um erro, mas nenhum erro ocorreu");
        Assertions.assertEquals(mensagemEsperada, erro.getMessage());
    }

    // CORREÇÃO AQUI (Linha ~72)
    @Então("o total do pedido com desconto deve ser {double}")
    public void o_total_do_pedido_com_desconto_deve_ser(Double esperado) {
        Assertions.assertNull(erro, "Não era esperado erro, mas ocorreu: " + (erro != null ? erro.getMessage() : ""));
        // 1. Divide o esperado por 100.0 para converter de centavos para Reais.
        // 2. Usa 0.001 de delta para comparação de double.
        Assertions.assertEquals(esperado / 100.0, total, 0.001); 
    }

    @Então("o tempo estimado deve ser {int}")
    public void o_tempo_estimado_deve_ser(Integer esperado) {
        Assertions.assertEquals(esperado.intValue(), tempo);
    }
}