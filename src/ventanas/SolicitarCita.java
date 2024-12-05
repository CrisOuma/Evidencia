package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SolicitarCita extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btncomfirm;
    private JComboBox textField4;
    private JPanel SoliCita;
    private JComboBox comboBox1;

    public SolicitarCita(){
        this.setTitle("Solicitud de cita");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(SoliCita); //
        btncomfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(SoliCita, "Si cita fue registrada con éxito. nos vemos x dia a x hora. para más detalles con su número de cita: xxxx");
            }
        });
    }
}
