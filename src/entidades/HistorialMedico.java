package entidades;

import java.io.Serializable;

public class HistorialMedico implements Serializable {
    private int clienteID;
    private String diagnostico;
    private String medicamentos;
    private String alergias;

    // Constructor
    public HistorialMedico(int clienteID, String diagnostico, String medicamentos, String alergias) {
        this.clienteID = clienteID;
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
    }

    // Métodos 'get'
    public int getClienteID() {
        return clienteID;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    // Opcional: Método toString para depuración
    @Override
    public String toString() {
        return "HistorialMedico{" +
                "clienteID=" + clienteID +
                ", diagnostico='" + diagnostico + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", alergias='" + alergias + '\'' +
                '}';
    }
}
