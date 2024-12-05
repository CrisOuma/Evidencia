package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ADMpage extends JFrame{
    private JPanel pnADMpage;
    private JButton listaDeDoctoresButton;
    private JButton listaDePacientesButton;

    public ADMpage(){
        this.setTitle("ADMpage");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(pnADMpage); //
        listaDeDoctoresButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DoctorList DocListWeb = new DoctorList();
                DocListWeb.setVisible(true);
            }
        });
        listaDePacientesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PatientsList PatienListWeb = new PatientsList();
                PatienListWeb.setVisible(true);
            }
        });
    }
}
