package org.example.frete.strategy;

public class FreteExpresso implements CalculadoraFrete {
    public double calcular(double peso) {
        if (peso <= 0)
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        return peso * 1.5 + 10;
    }
    public String getTipo() {
        return "EXP";
    }
}
