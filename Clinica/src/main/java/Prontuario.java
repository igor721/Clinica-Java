// Prontuario.java (Entidade de Domínio)
import java.util.HashSet;
import java.util.Set;

// Removidas as importações de java.io, java.nio.file, java.text, etc.
// O Prontuario deve ser uma classe pura de domínio, com Baixo Acoplamento e Alta Coesão (GRASP).
public class Prontuario {

    private String nomePaciente;
    private Internacao internacao;
    private Set<Procedimento> procedimentos = new HashSet<>();

    public Prontuario(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    // Getters e Setters simplificados

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomePaciente() {
        return this.nomePaciente;
    }

    public void setInternacao(Internacao internacao) {
        this.internacao = internacao;
    }

    public Internacao getInternacao() {
        return this.internacao;
    }

    public void addProcedimento(Procedimento procedimento) {
        this.procedimentos.add(procedimento);
    }

    public Set<Procedimento> getProcedimentos() {
        return this.procedimentos;
    }

    // **MÉTODOS DE NEGÓCIO E PERSISTÊNCIA REMOVIDOS**
    // - imprimaConta() -> Movido para CalculadoraDeConta
    // - salveProntuario() -> Movido para ProntuarioExportador
    // - criaProntuarioDeLinhaCSV() -> Movido para ProntuarioFabrica

    // Se a classe precisar imprimir a conta, ela DELEGA a responsabilidade.
    public String imprimirConta(CalculadoraDeConta calculadora) {
        return calculadora.imprimaConta(this);
    }
}