package org.example.frete.strategy;

import java.util.Map;
import java.util.HashMap;

public class CalculadoraFreteRegistry {
    private static final Map<String, CalculadoraFrete> REGISTRO = new HashMap<>();

    public static void registrar(CalculadoraFrete calculadora) {
        REGISTRO.put(calculadora.getTipo(), calculadora);
    }

    public static CalculadoraFrete obter(String tipo) {
        CalculadoraFrete calc = REGISTRO.get(tipo);
        if (calc == null)
            throw new RuntimeException("Tipo de frete inválido: " + tipo);
        return calc;
    }
}
