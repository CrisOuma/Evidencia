package entidades;

import java.io.Serializable;

public class HistorialMedico implements Serializable {
    private String diagnostico;
    private String medicamentos;
    private String alergias;

    public HistorialMedico(String diagnostico, String medicamentos, String alergias) {
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public void mostrarHistorial() {
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Medicamentos: " + medicamentos);
        System.out.println("Alergias: " + alergias);
    }
}

