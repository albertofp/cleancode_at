package org.example.frete.strategy;

import org.example.frete.domain.Entrega;

public class EtiquetaPadraoGenerator implements EtiquetaGenerator {
    public String gerar(Entrega entrega, double valorFrete) {
        return "Destinatário: " + entrega.getDestinatario() +
               "\nEndereço: " + entrega.getEndereco() +
               "\nValor do Frete: R$" + valorFrete;
    }
}
