package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServicioPaciente extends JFrame{
    private JPanel SerPacientes;
    private JButton btnCitaAgg;
    private JButton btnCitaRev;

    public ServicioPaciente(){
        this.setTitle("Ventana Paciente");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(SerPacientes); // Asigna el diseño del panel al JFrame
        btnCitaAgg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SolicitarCita SoliCitaWindow = new SolicitarCita();
                SoliCitaWindow.setVisible(true);
            }
        });
        btnCitaRev.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                IdCita IdCitaWindow = new IdCita();
                IdCitaWindow.setVisible(true);
            }
        });
    }
}
