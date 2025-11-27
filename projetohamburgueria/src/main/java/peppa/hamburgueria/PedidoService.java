package peppa.hamburgueria;

public class PedidoService {
    private final CardapioService cardapio;

    public PedidoService(CardapioService cardapio) {
        this.cardapio = cardapio;
    }

    public double calcularTotal(String item, int quantidade) {
        if (!cardapio.existe(item)) {
            throw new IllegalArgumentException("Item indisponível no cardápio");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
        double preco = cardapio.precoDe(item);
        double total = preco * quantidade;
        return Math.round(total * 100.0) / 100.0;
    }

    public int calcularTempoEstimado(int quantidadeTotal) {
        return 8 + 2 * quantidadeTotal;
    }
}
