package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Codigo extends JFrame{
    private JPanel numCita;
    private JTextField textField1;
    private JButton srchbtn;

    public Codigo(){
        this.setTitle("Codigo");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(numCita); // Asigna el diseño del panel al JFrame
        srchbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ServicioPaciente ServiceWindow = new ServicioPaciente();
                ServiceWindow.setVisible(true);
                setVisible(false);
            }
        });
    }
}
