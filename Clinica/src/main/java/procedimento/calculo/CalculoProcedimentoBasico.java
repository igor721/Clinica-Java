package main.java.procedimento.calculo;

import domain.calculo.CalculadoraCusto;

public class CalculoProcedimentoBasico implements CalculadoraCusto {
    @Override
    public float calcularCusto() {
        return 50f;
    }
}
