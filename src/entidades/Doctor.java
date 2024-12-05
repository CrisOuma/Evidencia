package entidades;

import java.io.Serializable;

public class Doctor extends Usuario implements Serializable {
    private String Contrasena;
    private String especialidad;
    private int Experiencia;

    public Doctor(int ID, String correo, String nombre, String contraseña, String especialidad, int Experiencia) {
        super(ID, correo, nombre);
        this.Contrasena = Contrasena;
        this.especialidad = especialidad;
        this.Experiencia = Experiencia;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(int experiencia) {
        Experiencia = experiencia;
    }
}
