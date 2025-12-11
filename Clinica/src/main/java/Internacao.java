// Internacao.java
public class Internacao {

    private TipoLeito tipoLeito;
    private int qtdeDias;

    public Internacao(TipoLeito tipoLeito, int qtdeDias) {
        this.tipoLeito = tipoLeito;
        this.qtdeDias = qtdeDias;
    }

    public TipoLeito getTipoLeito() {
        return this.tipoLeito;
    }

    public int getQtdeDias() {
        return this.qtdeDias;
    }

    // A Internacao é a especialista em calcular o seu custo.
    // OCP: Se a regra de desconto mudar, a lógica de cálculo se mantém aqui,
    // mas depende dos dados da Enum TipoLeito.
    public float calculaSubtotal() {
        float valorDiariaBase = tipoLeito.getValorDiariaBase();
        
        // Regra de negócio: Desconto após o terceiro dia
        if (qtdeDias <= 3) {
            return qtdeDias * valorDiariaBase;
        } else {
            int diasComDesconto = qtdeDias - 3;
            float valorSemDesconto = 3 * valorDiariaBase;
            float valorComDesconto = diasComDesconto * valorDiariaBase * tipoLeito.getFatorDesconto();
            return valorSemDesconto + valorComDesconto;
        }
    }
}