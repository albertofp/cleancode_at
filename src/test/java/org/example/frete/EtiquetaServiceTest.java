package org.example.frete;

import static org.junit.Assert.assertTrue;

import org.example.frete.domain.Entrega;
import org.example.frete.service.EtiquetaService;
import org.example.frete.strategy.CalculadoraFreteRegistry;
import org.example.frete.strategy.EtiquetaPadraoGenerator;
import org.example.frete.strategy.FreteExpresso;
import org.example.frete.strategy.FretePadrao;
import org.example.frete.strategy.FreteEconomico;
import org.example.frete.strategy.PromocaoFrete;
import org.example.frete.strategy.PromocaoPeso;
import org.junit.BeforeClass;
import org.junit.Test;

public class EtiquetaServiceTest {

    private final PromocaoFrete promocao = new PromocaoPeso();
    private final EtiquetaService etiquetaService = new EtiquetaService(new EtiquetaPadraoGenerator(), promocao);

    @BeforeClass
    public static void setUpRegistry() {
        CalculadoraFreteRegistry.registrar(new FreteExpresso());
        CalculadoraFreteRegistry.registrar(new FretePadrao());
        CalculadoraFreteRegistry.registrar(new FreteEconomico());
    }

    @Test
    public void testEtiquetaGerada() {
        Entrega entrega = new Entrega("Av Brasil", 40, "EXP", "Alberto");
        String etiqueta = etiquetaService.gerarEtiqueta(entrega);
        assertTrue(etiqueta.contains("Alberto"));
        assertTrue(etiqueta.contains("Av Brasil"));
        assertTrue(etiqueta.contains("R$"));
    }
}

