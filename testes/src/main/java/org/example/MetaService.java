package org.example;

public class MetaService {
    public double calcularProgresso(double metaTotal, double progressoAtual) {
        if (metaTotal <= 0) {
            throw new IllegalArgumentException("Meta total deve ser maior que zero.");
        }
        return (progressoAtual / metaTotal) * 100;
    }

}
