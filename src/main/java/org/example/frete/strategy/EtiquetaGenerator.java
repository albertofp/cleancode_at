package org.example.frete.strategy;

import org.example.frete.domain.Entrega;

public interface EtiquetaGenerator {
    String gerar(Entrega entrega, double valorFrete);
}
