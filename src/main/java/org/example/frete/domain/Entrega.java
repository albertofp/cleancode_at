package org.example.frete.domain;

public final class Entrega {
    private final String endereco;
    private final double peso;
    private final String tipoFrete;
    private final String destinatario;

    public Entrega(String endereco, double peso, String tipoFrete, String destinatario) {
        if (endereco == null || endereco.isEmpty())
            throw new IllegalArgumentException("Endereço inválido");
        if (destinatario == null || destinatario.isEmpty())
            throw new IllegalArgumentException("Destinatário inválido");
        if (tipoFrete == null || tipoFrete.isEmpty())
            throw new IllegalArgumentException("Tipo de frete inválido");
        if (peso < 0)
            throw new IllegalArgumentException("Peso negativo");
        this.endereco = endereco;
        this.peso = peso;
        this.tipoFrete = tipoFrete;
        this.destinatario = destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public String getDestinatario() {
        return destinatario;
    }
}
