package metodos;

import entidades.Doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorCRUD {
    private static final String FILE_PATH = "C:\\BD\\hospital\\doctores.dat";
    private List<Doctor> userDoctor = new ArrayList<>();

    public DoctorCRUD() {
        userDoctor = cargarDoctores();
        inicializarBase();
    }

    private void guardarDoctores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(userDoctor);
        } catch (IOException e) {
            System.out.println("Error al guardar doctores: " + e.getMessage());
        }
    }

    private void inicializarBase() {
        if (userDoctor.isEmpty()) {
            userDoctor.add(new Doctor(1, "doc1@hospital.com", "Dr. Smith", "password123", "Cardiología", 10));
            userDoctor.add(new Doctor(2, "doc2@hospital.com", "Dr. Brown", "securepass", "Neurología", 15));
            guardarDoctores();
        }
    }

    public int addDoctor(int ID, String Correo, String nombre, String Contrasena, String especialidad, int Experiencia) {
        if (ID <= 0 || Correo == null || Correo.isEmpty() ||
                nombre == null || nombre.isEmpty() ||
                Contrasena == null || Contrasena.isEmpty() ||
                especialidad == null || especialidad.isEmpty() ||
                Experiencia < 0) {
            return -1;
        }

        for (Doctor doctor : userDoctor) {
            if (doctor.getID() == ID) {
                return -2;
            }
        }

        Doctor nuevoDoctor = new Doctor(ID, Correo, nombre, Contrasena, especialidad, Experiencia);
        userDoctor.add(nuevoDoctor);
        guardarDoctores();
        return 1;
    }

    private List<Doctor> cargarDoctores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Doctor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public List<Doctor> listarDoctores() {
        return userDoctor;
    }

    public Doctor buscarDoctorPorID(int ID) {
        for (Doctor doctor : userDoctor) {
            if (doctor.getID() == ID) {
                return doctor;
            }
        }
        return null;
    }

    public boolean eliminarDoctor(int ID) {
        Doctor doctor = buscarDoctorPorID(ID);
        if (doctor != null) {
            userDoctor.remove(doctor);
            guardarDoctores();
            return true;
        }
        return false;
    }
}
