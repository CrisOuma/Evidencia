package ventanas;

import javax.swing.*;

public class PatientsList extends JFrame {
    private JButton btnADD;
    private JButton btnDelete;
    private JButton btnSrhc;
    private JPanel pnPatienList;

    public PatientsList(){
        this.setTitle("Lista de Pacientes");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(pnPatienList);
    }
}
