// CalculadoraDeConta.java
import java.util.Map;
import java.util.stream.Collectors;

public class CalculadoraDeConta {

    // Recebe o Prontuario e usa a responsabilidade de subtotal das classes Internacao e Procedimento
    public float calculaTotal(Prontuario prontuario) {
        float total = 0.0f;

        // 1. Cálculo da Internação (se houver)
        if (prontuario.getInternacao() != null) {
            total += prontuario.getInternacao().calculaSubtotal();
        }

        // 2. Cálculo dos Procedimentos
        for (Procedimento p : prontuario.getProcedimentos()) {
            total += p.calculaSubtotal();
        }

        return total;
    }

    // Método auxiliar para formatar a conta (extraído da antiga Prontuario)
    public String imprimaConta(Prontuario prontuario) {
        java.text.NumberFormat formatter = java.text.NumberFormat.getCurrencyInstance();
        float totalGeral = calculaTotal(prontuario);

        String conta = "----------------------------------------------------------------------------------------------\n";
        conta += "Conta do Paciente: " + prontuario.getNomePaciente() + "\n";
        conta += "----------------------------------------------------------------------------------------------\n";

        // Detalhes da Internação
        if (prontuario.getInternacao() != null) {
            Internacao internacao = prontuario.getInternacao();
            conta += String.format("Diárias de %s (%d dias): %s\n",
                    internacao.getTipoLeito(),
                    internacao.getQtdeDias(),
                    formatter.format(internacao.calculaSubtotal()));
        }

        // Detalhes dos Procedimentos
        if (!prontuario.getProcedimentos().isEmpty()) {
            // Agrupamento e ordenação (lógica de apresentação, OK ficar aqui)
            Map<TipoProcedimento, Long> procedimentosAgrupados = prontuario.getProcedimentos().stream()
                    .collect(Collectors.groupingBy(Procedimento::getTipoProcedimento, Collectors.counting()));

            for (Map.Entry<TipoProcedimento, Long> entry : procedimentosAgrupados.entrySet()) {
                long qtde = entry.getValue();
                TipoProcedimento tipo = entry.getKey();
                
                // O valor total de cada tipo é calculado pelo Procedimento * quantidade
                float subtotalTipo = prontuario.getProcedimentos().stream()
                                    .filter(p -> p.getTipoProcedimento() == tipo)
                                    .map(Procedimento::calculaSubtotal)
                                    .reduce(0.0f, Float::sum);

                conta += String.format("Procedimento %s (%d unidades): %s\n",
                        tipo, qtde, formatter.format(subtotalTipo));
            }
        }

        conta += "----------------------------------------------------------------------------------------------\n";
        conta += "Total Geral: " + formatter.format(totalGeral) + "\n";
        conta += "----------------------------------------------------------------------------------------------";
        
        return conta;
    }
}