public class Internacao {

    private final TipoLeito tipoLeito;
    private final int qtdeDias;

    public Internacao(TipoLeito tipoLeito, int qtdeDias) {
        this.tipoLeito = tipoLeito;
        this.qtdeDias = qtdeDias;
    }

    TipoLeito getTipoLeito() {
        return tipoLeito;
    }

    int getQtdeDias() {
        return qtdeDias;
    }

    double calcularValor() {
        return tipoLeito.valorDiaria(qtdeDias) * qtdeDias;
    }
}
