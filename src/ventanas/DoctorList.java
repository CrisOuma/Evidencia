package ventanas;

import javax.swing.*;

public class DoctorList extends JFrame{
    private JCheckBox checkBox1;
    private JPanel pnDocList;
    private JButton btnADD;
    private JButton btnDelete;
    private JCheckBox checkBox2;
    private JButton btnSrch;

    public DoctorList(){
        this.setTitle("Lista de doctores");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(pnDocList);
    }
}
