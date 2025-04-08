package org.example.frete.service;

import org.example.frete.domain.Entrega;
import org.example.frete.strategy.CalculadoraFrete;
import org.example.frete.strategy.CalculadoraFreteRegistry;
import org.example.frete.strategy.EtiquetaGenerator;
import org.example.frete.strategy.PromocaoFrete;

public class EtiquetaService {
    private final EtiquetaGenerator etiquetaGenerator;
    private final PromocaoFrete promocao;

    public EtiquetaService(EtiquetaGenerator etiquetaGenerator, PromocaoFrete promocao) {
        if (etiquetaGenerator == null)
            throw new IllegalArgumentException("EtiquetaGenerator nulo");
        if (promocao == null)
            throw new IllegalArgumentException("Promoção nula");
        this.etiquetaGenerator = etiquetaGenerator;
        this.promocao = promocao;
    }

    public String gerarEtiqueta(Entrega entrega) {
        CalculadoraFrete calc = CalculadoraFreteRegistry.obter(entrega.getTipoFrete());
        double valor = calc.calcular(entrega.getPeso());
        valor = promocao.aplicar(entrega, valor);
        return etiquetaGenerator.gerar(entrega, valor);
    }
}
