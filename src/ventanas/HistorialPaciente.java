package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HistorialPaciente extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JList list1;
    private JButton BtnClose;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel PnHistPaciente;

    public HistorialPaciente(){
        this.setTitle("Historial Médico");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(PnHistPaciente);
        BtnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
            }
        });
    }
}
