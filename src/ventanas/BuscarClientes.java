package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarClientes extends JFrame {
    private JTextField textField1;
    private JButton btnSrcClnt;
    private JPanel panelbuscar;
    private JLabel label;

    public BuscarClientes(){
        this.setTitle("Cliente Id");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(panelbuscar);
        btnSrcClnt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                HistorialPaciente HistWindow = new HistorialPaciente();
                HistWindow.setVisible(true);
            }
        });
    }
}
