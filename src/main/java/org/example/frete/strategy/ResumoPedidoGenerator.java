package org.example.frete.strategy;

import org.example.frete.domain.Entrega;

public class ResumoPedidoGenerator implements EtiquetaGenerator {
    public String gerar(Entrega entrega, double valorFrete) {
        return "Pedido para " + entrega.getDestinatario() +
               " com frete tipo " + entrega.getTipoFrete() +
               " no valor de R$" + valorFrete;
    }
}
