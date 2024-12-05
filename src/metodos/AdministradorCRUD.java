package metodos;

import entidades.Administrador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorCRUD {
    private static final String FILE_PATH = "C:\\BD\\hospital\\administradores.dat";
    private List<Administrador> administradores;

    public AdministradorCRUD() {
        administradores = cargarAdministradores();
        inicializarBase();
    }

    // Inicializar la lista con 2 administradores por defecto si el archivo está vacío
    private void inicializarBase() {
        if (administradores.isEmpty()) {
            administradores.add(new Administrador(1, "admin1@hospital.com", "Admin Uno", "admin1", "pass123"));
            administradores.add(new Administrador(2, "admin2@hospital.com", "Admin Dos", "admin2", "secure456"));
            guardarAdministradores();
        }
    }

    // Validar inicio de sesión
    public boolean validarLogin(String usuario, String contraseña) {
        for (Administrador admin : administradores) {
            if (admin.getUsuario().equals(usuario) && admin.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false; // Credenciales inválidas
    }

    // Cargar administradores desde el archivo
    private List<Administrador> cargarAdministradores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Administrador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public List<Administrador> listarAdministradores() {
        return administradores;
    }

    // Guardar administradores en el archivo
    private void guardarAdministradores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(administradores);
        } catch (IOException e) {
            System.out.println("Error al guardar administradores: " + e.getMessage());
        }
    }
}
