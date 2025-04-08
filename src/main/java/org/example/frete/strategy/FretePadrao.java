package org.example.frete.strategy;

public class FretePadrao implements CalculadoraFrete {
    public double calcular(double peso) {
        if (peso <= 0)
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        return peso * 1.2;
    }
    public String getTipo() {
        return "PAD";
    }
}
