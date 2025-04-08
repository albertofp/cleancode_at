package org.example.frete.service;

import org.example.frete.domain.Entrega;
import org.example.frete.strategy.CalculadoraFrete;
import org.example.frete.strategy.CalculadoraFreteRegistry;
import org.example.frete.strategy.PromocaoFrete;

public class FreteService {
    private final PromocaoFrete promocao;

    public FreteService(PromocaoFrete promocao) {
        if (promocao == null)
            throw new IllegalArgumentException("Promoção nula");
        this.promocao = promocao;
    }

    public double calcularFrete(Entrega entrega) {
        CalculadoraFrete calc = CalculadoraFreteRegistry.obter(entrega.getTipoFrete());
        double valor = calc.calcular(entrega.getPeso());
        return promocao.aplicar(entrega, valor);
    }
}
