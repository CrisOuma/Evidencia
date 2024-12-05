package metodos;

import entidades.Paciente;
import entidades.HistorialMedico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacientesCRUD {
    private static final String FILE_PATH = "C:\\BD\\hospital\\pacientes.dat";
    private List<Paciente> pacientes;

    public PacientesCRUD() {
        pacientes = cargarPacientes();
    }

    // Método para agregar un paciente
    public int addPaciente(int id, String nombre, String apellidoP, String apellidoM, String birthday, String contacto, HistorialMedico historialMedico) {
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
        pacientes.add(new Paciente(0001, "Leonardo", "Cano", "Ramírez", "01 November", "0101010101", historialMedico));
        pacientes.add(new Paciente(0002, "Rocio", "Álvarez", "Jiménez", "11 November", "1234567890", historialMedico));
        pacientes.add(new Paciente(0003, "Sebastián", "Chávez", "Álvarez", "05 Septiembre", "4104102410", historialMedico));
        pacientes.add(new Paciente(0004, "Armando", "Zavala", "Tenopala", "01 Septiembre", "7474745652", historialMedico));
        guardarPacientes();
        return 1; // Éxito
    }

    // Método para buscar un paciente por ID
    public Paciente buscarPorID(int id) {
        for (Paciente paciente : pacientes) {
            if (Paciente.getId() == id) {
                return paciente; // Retorna el paciente si coincide el ID
            }
        }
        return null; // Retorna null si no encuentra al paciente
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

