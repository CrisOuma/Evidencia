package ventanas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IdCita extends JFrame{
    private JPanel PnIdCita;
    private JTextField textField1;
    private JButton btnsrchcita;

    public IdCita(){
        this.setTitle("Buscar Cita");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        this.setContentPane(PnIdCita); //
        btnsrchcita.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RevisarCita RevCitaWindow = new RevisarCita();
                RevCitaWindow.setVisible(true);
                setVisible(false);
            }
        });
    }
}
