import main.java.calculo.CalculadoraCusto;

public class Procedimento {

    private final TipoProcedimento tipo;
    private final CalculadoraCusto calculadora;

    public Procedimento(TipoProcedimento tipo, CalculadoraCusto calculadora) {
        this.tipo = tipo;
        this.calculadora = calculadora;
    }

    public TipoProcedimento getTipo() {
        return tipo;
    }

    public float calcularCusto() {
        return calculadora.calcularCusto();
    }
}
