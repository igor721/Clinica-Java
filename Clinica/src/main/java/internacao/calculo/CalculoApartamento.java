package main.java.internacao.calculo;

import domain.calculo.CalculadoraCusto;

public class CalculoApartamento implements CalculadoraCusto {

    private final int dias;

    public CalculoApartamento(int dias) {
        this.dias = dias;
    }

    @Override
    public float calcularCusto() {
        if (dias <= 3) return dias * 100f;
        if (dias <= 8) return dias * 90f;
        return dias * 80f;
    }
}
