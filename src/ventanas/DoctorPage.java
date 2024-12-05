package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorPage extends JFrame {
    private JPanel PnDocPage;
    private JButton btnRevCitas;
    private JButton btnRevPaciente;

    public DoctorPage(){
        this.setTitle("Doctor Page");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(PnDocPage);
        btnRevCitas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                IdCita IdCitaWindow = new IdCita();
                IdCitaWindow.setVisible(true);
            }
        });

        btnRevPaciente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BuscarClientes SrchClientes = new BuscarClientes();
                SrchClientes.setVisible(true);
            }
        });
    }
}
