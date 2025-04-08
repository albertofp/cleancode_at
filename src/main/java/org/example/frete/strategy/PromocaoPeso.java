package org.example.frete.strategy;

import org.example.frete.domain.Entrega;

public class PromocaoPeso implements PromocaoFrete {
    public double aplicar(Entrega entrega, double valorFrete) {
        if (entrega.getPeso() > 10)
            return valorFrete - 1;
        return valorFrete;
    }
}
