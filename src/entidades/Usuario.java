package entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int ID;
    private String correo;
    private String nombre;

    public Usuario(int ID, String correo, String nombre){
        this.ID = ID;
        this.correo = correo;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
