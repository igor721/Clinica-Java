// ProntuarioFabrica.java (Fabrica Pura GRASP)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ProntuarioFabrica {

    // Mapeia a criação da Internacao e Procedimento para o Prontuario
    public Prontuario criaProntuarioDeLinhaCSV(Path path) throws IOException {
        
        // A lógica de criação do objeto é a única responsabilidade desta classe
        
        Prontuario prontuario = new Prontuario("Paciente Desconhecido"); // Valor inicial, será substituído
        
        try (Stream<String> stream = Files.lines(path)) {
            stream.skip(1).forEach(linha -> { // Pula o cabeçalho
                String[] colunas = linha.split(",");

                String nomePaciente = colunas[0];
                String tipoLeitoStr = colunas.length > 1 && !colunas[1].isEmpty() ? colunas[1].trim() : null;
                int qtdeDiasInternacao = colunas.length > 2 && !colunas[2].isEmpty() ? Integer.parseInt(colunas[2].trim()) : 0;
                String tipoProcedimentoStr = colunas.length > 3 && !colunas[3].isEmpty() ? colunas[3].trim() : null;
                int qtdeProcedimentos = colunas.length > 4 && !colunas[4].isEmpty() ? Integer.parseInt(colunas[4].trim()) : 0;

                prontuario.setNomePaciente(nomePaciente);

                // Criação da Internacao (A Fabrica sabe como criar)
                TipoLeito tipoLeito = null;
                if (tipoLeitoStr != null) {
                    try {
                        tipoLeito = TipoLeito.valueOf(tipoLeitoStr.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.err.println("Tipo de Leito inválido: " + tipoLeitoStr);
                    }
                }

                if (tipoLeito != null && qtdeDiasInternacao > 0) {
                    prontuario.setInternacao(new Internacao(tipoLeito, qtdeDiasInternacao));
                }

                // Criação dos Procedimentos (A Fabrica sabe como criar)
                TipoProcedimento tipoProcedimento = null;
                if (tipoProcedimentoStr != null) {
                     try {
                        tipoProcedimento = TipoProcedimento.valueOf(tipoProcedimentoStr.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.err.println("Tipo de Procedimento inválido: " + tipoProcedimentoStr);
                    }
                }

                if (tipoProcedimento != null && qtdeProcedimentos > 0) {
                    for (int i = 0; i < qtdeProcedimentos; i++) {
                        prontuario.addProcedimento(new Procedimento(tipoProcedimento));
                    }
                }
            });
        }
        
        return prontuario;
    }
}