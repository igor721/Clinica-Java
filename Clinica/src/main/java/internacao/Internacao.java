

import domain.calculo.CalculadoraCusto;

public class Internacao {
    private TipoLeito tipoLeito;
    private int qtdeDias;
    private CalculadoraCusto calculadora;

    public Internacao(TipoLeito tipoLeito, int qtdeDias, CalculadoraCusto calculadora) {
        this.tipoLeito = tipoLeito;
        this.qtdeDias = qtdeDias;
        this.calculadora = calculadora;
    }

    public TipoLeito getTipoLeito() {
        return tipoLeito;
    }

    public int getQtdeDias() {
        return qtdeDias;
    }

    public float calcularCusto() {
        return calculadora.calcularCusto();
    }
}
