package org.example.frete.strategy;

public class FreteEconomico implements CalculadoraFrete {
    public double calcular(double peso) {
        if (peso <= 0)
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        return peso * 1.1 - 5;
    }
    public String getTipo() {
        return "ECO";
    }
}
