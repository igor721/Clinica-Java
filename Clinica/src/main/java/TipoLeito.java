// TipoLeito.java
public enum TipoLeito {
    ENFERMARIA(100.00f, 0.9f), // Valor base e fator de desconto após 3 dias
    APARTAMENTO(200.00f, 0.8f);

    private final float valorDiariaBase;
    private final float fatorDesconto;

    TipoLeito(float valorDiariaBase, float fatorDesconto) {
        this.valorDiariaBase = valorDiariaBase;
        this.fatorDesconto = fatorDesconto;
    }

    public float getValorDiariaBase() {
        return valorDiariaBase;
    }

    public float getFatorDesconto() {
        return fatorDesconto;
    }
}