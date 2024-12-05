package entidades;

import java.io.Serializable;
import java.util.Date;

public class Paciente implements Serializable {
    private int id;
    private String nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String birthday;
    private String contacto;
    private HistorialMedico historialMedico;

    public Paciente (int id, String nombre, String apellidoP, String apellidoM, String birthday, String contacto, HistorialMedico historialMedico){
        this.id = id;
        this.nombre = nombre;
        this.ApellidoP = apellidoP;
        this.ApellidoM = apellidoM;
        this.birthday = birthday;
        this.contacto = contacto;
        this.historialMedico = historialMedico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String apellidoP) {
        ApellidoP = apellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String apellidoM) {
        ApellidoM = apellidoM;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

}
