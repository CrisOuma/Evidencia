package entidades;

import java.io.Serializable;

public final class Administrador extends Usuario implements Serializable {
    private String usuario;
    private String contraseña;

    public Administrador(int ID, String correo, String nombre, String usuario, String contraseña){
        super(ID, correo, nombre);
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
