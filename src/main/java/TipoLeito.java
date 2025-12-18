public enum TipoLeito {

    ENFERMARIA {
        @Override
        public double valorDiaria(int dias) {
            if (dias <= 3) return 40.0;
            if (dias <= 8) return 35.0;
            return 30.0;
        }
    },
    APARTAMENTO {
        @Override
        public double valorDiaria(int dias) {
            if (dias <= 3) return 100.0;
            if (dias <= 8) return 90.0;
            return 80.0;
        }
    };

    public abstract double valorDiaria(int dias);
}
