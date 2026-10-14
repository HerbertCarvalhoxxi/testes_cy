package com.xmen.sentinela.service;

import com.xmen.sentinela.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentinelaServiceBlindadoTest {

    private final SentinelaService service = new SentinelaService();

    @Test
    @DisplayName("Ataque ao Mutante Wolverine (Omege)")
    void testeAtacarMutante() {
        // Arrange
        Sentinela markV = new Sentinela("Mark V", 100);
        Alvo wolverine = new Alvo("Logan", TipoAlvo.MUTANTE, 90);

        // Act
        boolean resultado = service.atacar(markV, wolverine);

        // Asserção básica do teste inicial (deixa vários mutantes sobreviverem!)
        assertTrue(resultado, "Valida apenas que o retorno foi true");

        // =========================================================================
        // 🟢 DESCOMENTE EM SALA PARA MATAR OS MUTANTES DE ATAQUE:
        // =========================================================================
        // assertEquals(60, markV.getNivelBateria(), "Mata MathMutator (- por +) e erro de custo OMEGA");
        // assertEquals(60, markV.getTemperaturaMotor(), "Mata MathMutator no aquecimento (+ por -)");
        // assertEquals(1, markV.getBaixasConfirmadas(), "Mata VoidMethodCallMutator (remocao do incremento)");
    }

    @Test
    @DisplayName("Recusa de Ataque a Humanos")
    void testeNaoAtacarHumano() {
        // Arrange
        Sentinela markV = new Sentinela("Mark V", 100);
        Alvo moira = new Alvo("Moira MacTaggert", TipoAlvo.HUMANO, 10);

        // Act
        boolean resultado = service.atacar(markV, moira);

        // Asserção básica
        assertFalse(resultado, "Valida apenas que não atacou humano");

        // =========================================================================
        // 🟢 DESCOMENTE EM SALA PARA VALIDAR A INTEGRIDADE DO SENTINELA:
        // =========================================================================
        // assertEquals(100, markV.getNivelBateria(), "Garante bateria intacta");
        // assertEquals(40, markV.getTemperaturaMotor(), "Garante temperatura intacta");
        // assertEquals(0, markV.getBaixasConfirmadas(), "Garante contador intacto");
    }

    // =============================================================================
    // 🟢 DESCOMENTE OS MÉTODOS ABAIXO EM SALA PARA MATAR 'NO_COVERAGE' E BOUNDARIES
    // =============================================================================

    /*
    @Test
    @DisplayName("Teste de Fronteira (Boundary) para Avaliação de Ameaça")
    void testeLimitesExatosAmeaca() {
        Alvo alvoOmega = new Alvo("Ciclope", TipoAlvo.MUTANTE, 80); // Limite exato OMEGA
        Alvo alvoAlto = new Alvo("Noturno", TipoAlvo.MUTANTE, 79);  // 1 ponto abaixo -> ALTO

        // Mata ConditionalsBoundaryMutator (troca de '>=' por '>')
        assertEquals(NivelAmeaca.OMEGA, service.avaliarAmeaca(alvoOmega), "Valida limite exato 80");
        assertEquals(NivelAmeaca.ALTO, service.avaliarAmeaca(alvoAlto), "Valida valor 79 abaixo da fronteira");
    }
    */

    /*
    @Test
    @DisplayName("Teste de Exceção ao Acionar Propulsores")
    void testeAcionarPropulsoresExcecao() {
        Sentinela markV = new Sentinela("Mark V", 14);

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> service.acionarPropulsores(markV));
        assertEquals("Energia insuficiente para decolar.", ex.getMessage());
        assertFalse(markV.isEmVoo(), "Sentinela nao decola sem bateria");
    }
    */

    /*
    @Test
    @DisplayName("Teste de Apresentação Formatada")
    void testeApresentarSe() {
        Sentinela markV = new Sentinela("Mark V", 100);
        String apresentacao = service.apresentarSe(markV);
        assertEquals("Sentinela Mark V | Bateria: 100% | Status: EM SOLO", apresentacao);
    }
    */

    /*
    @Test
    @DisplayName("Teste de Protocolo de Emergência")
    void testeExecutarProtocoloEmergencia() {
        Sentinela markV = new Sentinela("Mark V", 100);
        markV.setTemperaturaMotor(95);
        markV.setEmVoo(true);

        boolean ativou = service.executarProtocoloEmergencia(markV);
        assertTrue(ativou);
        assertFalse(markV.isEmVoo());
        assertEquals(30, markV.getTemperaturaMotor());
    }
    */
}