package com.xmen.sentinela.service;

import com.xmen.sentinela.domain.*;
import org.springframework.stereotype.Service;

@Service
public class SentinelaService {

    private static final int ENERGIA_MINIMA_VOO = 15;
    private static final int CUSTO_ATAQUE_PADRAO = 20;
    private static final int LIMITE_SOBREAQUECIMENTO = 90;

    public String apresentarSe(Sentinela sentinela) {
        return String.format("Sentinela %s | Bateria: %d%% | Status: %s",
                sentinela.getModelo(),
                sentinela.getNivelBateria(),
                sentinela.isEmVoo() ? "EM VOO" : "EM SOLO");
    }

    public void acionarPropulsores(Sentinela sentinela) {
        if (sentinela.getNivelBateria() < ENERGIA_MINIMA_VOO) {
            throw new IllegalStateException("Energia insuficiente para decolar.");
        }
        sentinela.setEmVoo(true);
        sentinela.setNivelBateria(sentinela.getNivelBateria() - ENERGIA_MINIMA_VOO);
        sentinela.setTemperaturaMotor(sentinela.getTemperaturaMotor() + 15);
    }

    public NivelAmeaca avaliarAmeaca(Alvo alvo) {
        if (alvo.getTipo() != TipoAlvo.MUTANTE) {
            return NivelAmeaca.BAIXO;
        }

        if (alvo.getNivelPoder() >= 80) {
            return NivelAmeaca.OMEGA;
        } else if (alvo.getNivelPoder() >= 40) {
            return NivelAmeaca.ALTO;
        }

        return NivelAmeaca.BAIXO;
    }

    public boolean atacar(Sentinela sentinela, Alvo alvo) {
        if (alvo.getTipo() != TipoAlvo.MUTANTE) {
            return false;
        }

        if (sentinela.getTemperaturaMotor() >= LIMITE_SOBREAQUECIMENTO) {
            return false;
        }

        NivelAmeaca ameaca = avaliarAmeaca(alvo);
        int custoEnergia = (ameaca == NivelAmeaca.OMEGA) ? CUSTO_ATAQUE_PADRAO * 2 : CUSTO_ATAQUE_PADRAO;

        if (sentinela.getNivelBateria() < custoEnergia) {
            return false;
        }

        sentinela.setNivelBateria(sentinela.getNivelBateria() - custoEnergia);
        sentinela.setTemperaturaMotor(sentinela.getTemperaturaMotor() + 20);
        sentinela.incrementarBaixas();

        return true;
    }

    public boolean executarProtocoloEmergencia(Sentinela sentinela) {
        if (sentinela.getTemperaturaMotor() > LIMITE_SOBREAQUECIMENTO || sentinela.getNivelBateria() <= 5) {
            sentinela.setEmVoo(false);
            sentinela.setTemperaturaMotor(30);
            return true;
        }
        return false;
    }
}
