// Procedimento.java
public class Procedimento {

    private TipoProcedimento tipoProcedimento;

    public Procedimento(TipoProcedimento tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public TipoProcedimento getTipoProcedimento() {
        return this.tipoProcedimento;
    }

    // O Procedimento é o especialista em calcular o seu custo (SRP e Especialista da Informação)
    public float calculaSubtotal() {
        return tipoProcedimento.getValorBase();
    }
}