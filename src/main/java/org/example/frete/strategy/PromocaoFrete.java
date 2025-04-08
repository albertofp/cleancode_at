package org.example.frete.strategy;

import org.example.frete.domain.Entrega;

public interface PromocaoFrete {
    double aplicar(Entrega entrega, double valorFrete);
}
