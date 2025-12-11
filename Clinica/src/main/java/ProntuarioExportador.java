// ProntuarioExportador.java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProntuarioExportador {

    // O nome do arquivo não deve ser responsabilidade da classe Exportador, 
    // mas sim de quem o chama. Aqui usamos um valor fixo apenas para compatibilidade com o original.
    private static final String NOME_ARQUIVO = "l.txt";

    public String exportarParaCSV(Prontuario prontuario) throws IOException {
        List<String> linhas = new ArrayList<>();
        
        // Cabeçalho
        linhas.add("nome_paciente,tipo_leito,qtde_dias_internacao,tipo_procedimento,qtde_procedimentos");

        String nomePaciente = prontuario.getNomePaciente();
        Internacao internacao = prontuario.getInternacao();

        // Linha com Internação
        if (internacao != null) {
            String linhaInternacao = String.format("%s,%s,%d,,",
                    nomePaciente,
                    internacao.getTipoLeito(),
                    internacao.getQtdeDias());
            linhas.add(linhaInternacao);
        }

        // Linhas com Procedimentos
        if (!prontuario.getProcedimentos().isEmpty()) {
            // Agrupamento por TipoProcedimento
            Map<TipoProcedimento, Long> procedimentosAgrupados = prontuario.getProcedimentos().stream().collect(
                    Collectors.groupingBy(Procedimento::getTipoProcedimento, Collectors.counting()));

            // Ordena os tipos para consistência
            List<TipoProcedimento> procedimentosOrdenados = new ArrayList<>(procedimentosAgrupados.keySet());
            Collections.sort(procedimentosOrdenados); // Assumindo que TipoProcedimento é comparável ou implementa Comparable

            for (TipoProcedimento tipo : procedimentosOrdenados) {
                String linhaProcedimento = String.format("%s,,, %s,%d",
                        nomePaciente,
                        tipo,
                        procedimentosAgrupados.get(tipo));
                linhas.add(linhaProcedimento);
            }
        }
        
        // Salvar no arquivo
        Path caminho = Paths.get(NOME_ARQUIVO);
        Files.write(caminho, linhas);

        return caminho.toAbsolutePath().toString();
    }
}