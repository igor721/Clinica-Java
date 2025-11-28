package main.java.internacao.calculo;

import domain.calculo.CalculadoraCusto;

public class CalculoEnfermaria implements CalculadoraCusto {

    private final int dias;

    public CalculoEnfermaria(int dias) {
        this.dias = dias;
    }

    @Override
    public float calcularCusto() {
        if (dias <= 3) return dias * 40f;
        if (dias <= 8) return dias * 35f;
        return dias * 30f;
    }
}
