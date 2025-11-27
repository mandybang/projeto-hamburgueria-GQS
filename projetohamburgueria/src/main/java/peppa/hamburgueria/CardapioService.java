package peppa.hamburgueria;

import java.util.HashMap;
import java.util.Map;

public class CardapioService {
    private final Map<String, Double> precos = new HashMap<>();

    public void cadastrarItem(String nome, double preco) {
        precos.put(nome, preco);
    }

    public boolean existe(String nome) {
        return precos.containsKey(nome);
    }

    public double precoDe(String nome) {
        return precos.getOrDefault(nome, 0.0);
    }
}
