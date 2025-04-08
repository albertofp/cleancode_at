package org.example.frete.strategy;

public interface CalculadoraFrete {
    double calcular(double peso);
    String getTipo();
}
