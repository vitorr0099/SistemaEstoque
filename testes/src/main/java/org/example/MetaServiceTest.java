package org.example;

import org.example.MetaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetaServiceTest {

    MetaService metaService = new MetaService();

    @Test
    void testCalculoProgressoMetas() {
        // Configurando a meta
        double metaTotal = 10.0; // Meta: reduzir 10 toneladas de carbono

        // Primeira atualização
        double progressoAtual = 4.0; // Redução de 4 toneladas
        double progressoEsperado = 40.0;
        double progressoCalculado = metaService.calcularProgresso(metaTotal, progressoAtual);

        assertEquals(progressoEsperado, progressoCalculado, 0.01, "O progresso após a primeira atualização deve ser 40%.");

        // Segunda atualização
        progressoAtual = 7.0; // Redução acumulada: 7 toneladas
        progressoEsperado = 70.0;
        progressoCalculado = metaService.calcularProgresso(metaTotal, progressoAtual);

        assertEquals(progressoEsperado, progressoCalculado, 0.01, "O progresso após a segunda atualização deve ser 70%.");
    }

    @Test
    void testCalculoProgressoMetaTotalZero() {
        // Cenário de meta inválida
        double metaTotal = 0.0;
        double progressoAtual = 5.0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            metaService.calcularProgresso(metaTotal, progressoAtual);
        });

        assertEquals("Meta total deve ser maior que zero.", exception.getMessage());
    }
}
