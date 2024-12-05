package metodos;

import entidades.Paciente;
import entidades.HistorialMedico;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacientesCRUD {
    private static final String FILE_PATH = "C:\\BD\\hospital\\pacientes.dat";
    private List<Paciente> pacientes;

    public PacientesCRUD() {
        pacientes = cargarPacientes();
    }

    // Método para agregar un paciente
    public int addPaciente(int id, String nombre, String apellidoP, String apellidoM, Date birthday, String contacto, HistorialMedico historialMedico) {
        // Validaciones
        if (id <= 0 || nombre == null || nombre.isEmpty() ||
                apellidoP == null || apellidoP.isEmpty() ||
                apellidoM == null || apellidoM.isEmpty() ||
                birthday == null || contacto == null || contacto.isEmpty() || historialMedico == null) {
            return -1; // Error por campos inválidos
        }

        // Verificar que no exista un paciente con el mismo ID
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return -2; // ID duplicado
            }
        }

        // Crear y agregar el nuevo paciente
        Paciente nuevoPaciente = new Paciente(id, nombre, apellidoP, apellidoM, birthday, contacto, historialMedico);
        pacientes.add(nuevoPaciente);
        guardarPacientes();
        return 1; // Éxito
    }

    // Método para listar todos los pacientes
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    // Método para buscar un paciente por ID
    public Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null; // No encontrado
    }

    // Método para eliminar un paciente por ID
    public boolean eliminarPaciente(int id) {
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            guardarPacientes();
            return true; // Eliminado con éxito
        }
        return false; // No encontrado
    }

    // Cargar pacientes desde el archivo
    private List<Paciente> cargarPacientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Paciente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Guardar pacientes en el archivo
    private void guardarPacientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(pacientes);
        } catch (IOException e) {
            System.out.println("Error al guardar pacientes: " + e.getMessage());
        }
    }
}

