import domain.internacao.Internacao;
import domain.procedimento.Procedimento;

import java.util.HashSet;
import java.util.Set;

public class Prontuario {

    private String nome;
    private Internacao internacao;
    private Set<Procedimento> procedimentos = new HashSet<>();

    public Prontuario(String nome) {
        this.nome = nome;
    }

    public void setInternacao(Internacao internacao) {
        this.internacao = internacao;
    }

    public void adicionarProcedimento(Procedimento p) {
        procedimentos.add(p);
    }

    public String getNome() {
        return nome;
    }

    public Internacao getInternacao() {
        return internacao;
    }

    public Set<Procedimento> getProcedimentos() {
        return procedimentos;
    }
}
