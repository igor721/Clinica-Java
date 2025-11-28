package service;

import prontuario.Prontuario.java;

public class ContaHospitalarService {

    public float calcularTotal(Prontuario prontuario) {
        float total = 0;

        if (prontuario.getInternacao() != null) {
            total += prontuario.getInternacao().calcularCusto();
        }

        for (Procedimento p : prontuario.getProcedimentos()) {
            total += p.calcularCusto();
        }

        return total;
    }
}
