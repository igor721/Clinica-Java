package main.java.procedimento.calculo;

import domain.calculo.CalculadoraCusto;

public class CalculoProcedimentoComum implements CalculadoraCusto {
    @Override
    public float calcularCusto() {
        return 150f;
    }
}
