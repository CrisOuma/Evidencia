package metodos;

import entidades.Citas;

import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CitasCRUD {
    private static final String FILE_PATH = "C:\\BD\\hospital\\citas.dat";
    private List<Citas> citas;

    public CitasCRUD() {
        citas = cargarCitas();
    }

    // Método para agregar una cita
    public int addCita(Date fecha, Time hora, String motivo, int idC) {
        if (fecha == null || hora == null || motivo == null || motivo.isEmpty() || idC <= 0) {
            return -1; // Campos inválidos
        }

        // Verificar que no exista una cita con el mismo ID
        for (Citas cita : citas) {
            if (cita.getIdC() == idC) {
                return -2; // ID duplicado
            }
        }

        Citas nuevaCita = new Citas(fecha, hora, motivo, idC);
        citas.add(nuevaCita);
        guardarCitas();
        return 1; // Éxito
    }

    // Método para listar todas las citas
    public List<Citas> listarCitas() {
        return citas;
    }

    // Método para eliminar una cita por ID
    public boolean eliminarCita(int idC) {
        for (Citas cita : citas) {
            if (cita.getIdC() == idC) {
                citas.remove(cita);
                guardarCitas();
                return true; // Eliminada con éxito
            }
        }
        return false; // No encontrada
    }

    // Cargar citas desde el archivo
    private List<Citas> cargarCitas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Citas>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Guardar citas en el archivo
    private void guardarCitas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(citas);
        } catch (IOException e) {
            System.out.println("Error al guardar citas: " + e.getMessage());
        }
    }
}
