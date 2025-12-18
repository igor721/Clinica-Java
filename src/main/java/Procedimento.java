public class Procedimento {

    private final TipoProcedimento tipoProcedimento;

    public Procedimento(TipoProcedimento tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public TipoProcedimento getTipoProcedimento() {
        return tipoProcedimento;
    }

    public double getValor() {
        return tipoProcedimento.getValor();
    }
}
