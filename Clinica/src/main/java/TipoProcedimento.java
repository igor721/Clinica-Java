// TipoProcedimento.java
public enum TipoProcedimento {
    BASICO(50.00f),
    COMUM(150.00f),
    AVANCADO(500.00f);

    private final float valorBase;

    TipoProcedimento(float valorBase) {
        this.valorBase = valorBase;
    }

    public float getValorBase() {
        return valorBase;
    }
}