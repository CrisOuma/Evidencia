package metodos;

import entidades.HistorialMedico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedicoCRUD {
    private static final String FILE_PATH = "C:\\BD\\hospital\\historiales.dat";
    private List<HistorialMedico> historiales;

    public HistorialMedicoCRUD() {
        historiales = cargarHistoriales();
    }

    // Método para agregar un historial médico
    public int addHistorial(int clienteID, String diagnostico, String medicamentos, String alergias) {
        if (diagnostico == null || diagnostico.isEmpty() ||
                medicamentos == null || medicamentos.isEmpty() ||
                alergias == null || alergias.isEmpty()) {
            return -1; // Campos inválidos
        }

        HistorialMedico nuevoHistorial = new HistorialMedico(clienteID, diagnostico, medicamentos, alergias);
        historiales.add(nuevoHistorial);
        guardarHistoriales();
        return 1; // Éxito
    }

    // Método para listar todos los historiales médicos
    public List<HistorialMedico> listarHistoriales() {
        return historiales;
    }

    // Cargar historiales desde el archivo
    private List<HistorialMedico> cargarHistoriales() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<HistorialMedico>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Guardar historiales en el archivo
    private void guardarHistoriales() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(historiales);
        } catch (IOException e) {
            System.out.println("Error al guardar historiales: " + e.getMessage());
        }
    }
    // Buscar historial médico por clienteID
    public HistorialMedico buscarPorClienteID(int clienteID) {
        for (HistorialMedico historial : historiales) {
            if (historial.getClienteID() == clienteID) {
                return historial;
            }
        }
        return null; // No se encontró un historial para el clienteID
    }

}
