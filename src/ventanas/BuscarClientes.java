package ventanas;

import entidades.Paciente;
import metodos.PacientesCRUD;
import metodos.HistorialMedicoCRUD;
import entidades.HistorialMedico;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarClientes extends JFrame {
    private JTextField srchuss; // Campo para ingresar el ID
    private JButton btnSrcClnt; // Botón de búsqueda
    private JPanel panelbuscar;
    private JLabel label;

    public BuscarClientes() {
        this.setTitle("Buscar Paciente por ID");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panelbuscar);

        btnSrcClnt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Validar entrada de ID
                String inputId = srchuss.getText().trim();
                if (inputId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int clienteID = Integer.parseInt(inputId);

                    // Buscar datos del paciente
                    PacientesCRUD pacientesCRUD = new PacientesCRUD();
                    HistorialMedicoCRUD historialCRUD = new HistorialMedicoCRUD();

                    Paciente paciente = pacientesCRUD.buscarPorID(clienteID);
                    HistorialMedico historial = historialCRUD.buscarPorClienteID(clienteID);

                    if (paciente == null) {
                        JOptionPane.showMessageDialog(null, "No se encontró un paciente con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (historial == null) {
                        JOptionPane.showMessageDialog(null, "No se encontró un historial médico para este paciente.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Abrir la ventana del historial médico con los datos del paciente y su historial
                    HistorialPaciente historialPacienteWindow = new HistorialPaciente(
                            Paciente.getNombre(),
                            Paciente.getApellidoP(),
                            Paciente.getApellidoM(),
                            HistorialMedico.getAlergias(),
                            HistorialMedico.getDiagnostico(),
                            HistorialMedico.getMedicamentos()
                    );
                    historialPacienteWindow.setVisible(true);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
