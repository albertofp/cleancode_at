package org.example.frete;

import static org.junit.Assert.assertEquals;

import org.example.frete.domain.Entrega;
import org.example.frete.service.FreteService;
import org.example.frete.strategy.CalculadoraFreteRegistry;
import org.example.frete.strategy.FreteEconomico;
import org.example.frete.strategy.FreteExpresso;
import org.example.frete.strategy.FretePadrao;
import org.example.frete.strategy.PromocaoFrete;
import org.example.frete.strategy.PromocaoPeso;
import org.junit.BeforeClass;
import org.junit.Test;

public class FreteServiceTest {

    private final PromocaoFrete promocao = new PromocaoPeso();
    private final FreteService freteService = new FreteService(promocao);

    @BeforeClass
    public static void setUpRegistry() {
        CalculadoraFreteRegistry.registrar(new FreteExpresso());
        CalculadoraFreteRegistry.registrar(new FretePadrao());
        CalculadoraFreteRegistry.registrar(new FreteEconomico());
    }

    @Test
    public void testFreteExpresso() {
        Entrega entrega = new Entrega("Rua A", 5, "EXP", "João");
        double frete = freteService.calcularFrete(entrega);
        double esperado = (5 * 1.5 + 10);
        assertEquals(esperado, frete, 0.001);
    }

    @Test
    public void testFretePadrao() {
        Entrega entrega = new Entrega("Rua B", 8, "PAD", "Maria");
        double frete = freteService.calcularFrete(entrega);
        double esperado = (8 * 1.2);
        assertEquals(esperado, frete, 0.001);
    }

    @Test
    public void testFreteEconomicoComPromocao() {
        Entrega entrega = new Entrega("Rua C", 12, "ECO", "Carlos");
        double frete = freteService.calcularFrete(entrega);
        double esperado = (12 * 1.1 - 5) - 1;
        assertEquals(esperado, frete, 0.001);
    }
}
